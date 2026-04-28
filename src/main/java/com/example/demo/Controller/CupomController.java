package com.example.demo.Controller;

import com.example.demo.DTO.Cupom.CupomCreateDTO;
import com.example.demo.DTO.Cupom.CupomDTO;
import com.example.demo.DTO.Cupom.CupomUpdateDTO;
import com.example.demo.Exception.ApiError;
import com.example.demo.Service.CupomService;
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
@RequestMapping("/cupom")
@Tag(name = "Cupons", description = "API para gerenciamento de cupons")
public class CupomController {

    private final CupomService cupomService;

    public CupomController(CupomService cupomService) {
        this.cupomService = cupomService;
    }

    @GetMapping("/{id}")
    @Operation(summary = "Retornar um cupom", description = "Retorna cupom pelo ID")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Sucesso"),
            @ApiResponse(responseCode = "500", description = "Erro interno", content = @Content(schema = @Schema(implementation = ApiError.class)))
    })
    public CupomDTO findById(@PathVariable Long id) {
        return cupomService.findById(id);
    }

    @GetMapping
    @Operation(summary = "Listar cupons", description = "Retorna todos os cupons cadastrados")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Sucesso"),
            @ApiResponse(responseCode = "500", description = "Erro interno", content = @Content(schema = @Schema(implementation = ApiError.class)))
    })
    public List<CupomDTO> findAll() {
        return cupomService.findAll();
    }

    @PostMapping
    @Operation(summary = "Cadastrar cupom")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "201", description = "Cupom criado com sucesso"),
            @ApiResponse(responseCode = "400", description = "Dados inválidos", content = @Content(schema = @Schema(implementation = ApiError.class))),
            @ApiResponse(responseCode = "500", description = "Erro interno", content = @Content(schema = @Schema(implementation = ApiError.class)))
    })
    public CupomDTO create(@RequestBody @Valid CupomCreateDTO cupom) {
        return cupomService.save(cupom);
    }

    @PatchMapping("/{id}")
    @Operation(summary = "Atualizar cupom", description = "Atualiza os dados de um cupom existente")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Cupom atualizado com sucesso"),
            @ApiResponse(responseCode = "404", description = "Cupom não encontrado", content = @Content(schema = @Schema(implementation = ApiError.class)))
    })
    public CupomDTO update(@PathVariable Long id, @RequestBody @Valid CupomUpdateDTO cupom) {
        return cupomService.update(id, cupom);
    }

    //implementar autenticação de delete
    @DeleteMapping("/{id}")
    @Operation(summary = "Deletar cupom", description = "Remove um cupom pelo ID")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "204", description = "Cupom deletado com sucesso"),
            @ApiResponse(responseCode = "404", description = "Cupom não encontrado", content = @Content(schema = @Schema(implementation = ApiError.class)))
    })
    public void delete(@PathVariable Long id) {
        cupomService.delete(id);
    }

}
