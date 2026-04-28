package com.example.demo.Controller;

import com.example.demo.DTO.Credencial.CredencialDTO;
import com.example.demo.DTO.Credencial.CredencialUpdateDTO;
import com.example.demo.Exception.ApiError;
import com.example.demo.Service.CredencialService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/credencial")
@Tag(name = "Credenciais", description = "API para gerenciamento de credenciais")
public class CredencialController {

    // @RequestBody converte o JSON enviado na requisição em um objeto Java
    // @PathVariable pega o valor que vem na URL (ex: /credenciais/5 → id = 5)

    private final CredencialService credencialService;

    public CredencialController(CredencialService credencialService) {
        this.credencialService = credencialService;
    }

    @GetMapping("/{id}")
    @Operation(summary = "Retornar uma credencial", description = "Retorna credencial pelo ID")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Sucesso"),
            @ApiResponse(responseCode = "500", description = "Erro interno", content = @Content(schema = @Schema(implementation = ApiError.class)))
    })
    public CredencialDTO findById(@PathVariable Long id) {
        return credencialService.findById(id);
    }

    @GetMapping
    @Operation(summary = "Listar credenciais", description = "Retorna todas as credenciais cadastradas")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Sucesso"),
            @ApiResponse(responseCode = "500", description = "Erro interno", content = @Content(schema = @Schema(implementation = ApiError.class)))
    })
    public List<CredencialDTO> findAll() {
        return credencialService.findAll();
    }

    @PatchMapping("/{id}")
    @Operation(summary = "Atualizar credencial", description = "Atualiza os dados de uma credencial existente")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Credencial atualizada com sucesso"),
            @ApiResponse(responseCode = "404", description = "Credencial não encontrada", content = @Content(schema = @Schema(implementation = ApiError.class)))
    })
    public CredencialDTO update(@PathVariable Long id, @RequestBody @Valid CredencialUpdateDTO credencial) {
        return credencialService.update(id, credencial);
    }

    //implementar autenticação de delete
    @DeleteMapping("/{id}")
    @Operation(summary = "Deletar credencial", description = "Remove uma credencial pelo ID")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "204", description = "Credencial deletada com sucesso"),
            @ApiResponse(responseCode = "404", description = "Credencial não encontrada", content = @Content(schema = @Schema(implementation = ApiError.class)))
    })
    public void delete(@PathVariable Long id) {
        credencialService.delete(id);
    }


}

