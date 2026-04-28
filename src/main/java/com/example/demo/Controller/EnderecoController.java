package com.example.demo.Controller;

import com.example.demo.DTO.Endereco.EnderecoCreateDTO;
import com.example.demo.DTO.Endereco.EnderecoDTO;
import com.example.demo.DTO.Endereco.EnderecoUpdateDTO;
import com.example.demo.DTO.Usuario.UsuarioDTO;
import com.example.demo.Exception.ApiError;
import com.example.demo.Service.EnderecoService;
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
@RequestMapping("/endereco")
@Tag(name = "Enderecos", description = "API para gerenciamento de endereços")
public class EnderecoController {

    private final EnderecoService enderecoService;

    public EnderecoController(EnderecoService enderecoService) {
        this.enderecoService = enderecoService;
    }

    @GetMapping("/{id}")
    @Operation(summary = "Retornar um endereço", description = "Retorna endereço pelo ID")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Sucesso"),
            @ApiResponse(responseCode = "500", description = "Erro interno", content = @Content(schema = @Schema(implementation = ApiError.class)))
    })
    public EnderecoDTO findById(@PathVariable Long id) {
        return enderecoService.findById(id);
    }

    @GetMapping
    @Operation(summary = "Listar endereços", description = "Retorna todos os endereços cadastrados")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Sucesso"),
            @ApiResponse(responseCode = "500", description = "Erro interno", content = @Content(schema = @Schema(implementation = ApiError.class)))
    })
    public List<EnderecoDTO> findAll() {
        return enderecoService.findAll();
    }

    @PostMapping
    @Operation(summary = "Cadastrar endereço")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "201", description = "Endereço criado com sucesso"),
            @ApiResponse(responseCode = "400", description = "Dados inválidos", content = @Content(schema = @Schema(implementation = ApiError.class))),
            @ApiResponse(responseCode = "500", description = "Erro interno", content = @Content(schema = @Schema(implementation = ApiError.class)))
    })
    public EnderecoDTO create(@RequestBody @Valid EnderecoCreateDTO endereco) {
        return enderecoService.save(endereco);
    }

    @PatchMapping("/{id}")
    @Operation(summary = "Atualizar endereço", description = "Atualiza os dados de um endereço existente")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Endereço atualizado com sucesso"),
            @ApiResponse(responseCode = "404", description = "Endereço não encontrado", content = @Content(schema = @Schema(implementation = ApiError.class)))
    })
    public EnderecoDTO update(@PathVariable Long id, @RequestBody @Valid EnderecoUpdateDTO endereco) {
        return enderecoService.update(id, endereco);
    }

    //implementar autenticação de delete
    @DeleteMapping("/{id}")
    @Operation(summary = "Deletar endereço", description = "Remove um endereço pelo ID")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "204", description = "Endereço deletado com sucesso"),
            @ApiResponse(responseCode = "404", description = "Endereço não encontrado", content = @Content(schema = @Schema(implementation = ApiError.class)))
    })
    public void delete(@PathVariable Long id) {
        enderecoService.delete(id);
    }

}
