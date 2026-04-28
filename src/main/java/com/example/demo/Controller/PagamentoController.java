package com.example.demo.Controller;

import com.example.demo.DTO.Endereco.EnderecoCreateDTO;
import com.example.demo.DTO.Endereco.EnderecoDTO;
import com.example.demo.DTO.Endereco.EnderecoUpdateDTO;
import com.example.demo.DTO.Pagamento.PagamentoDTO;
import com.example.demo.DTO.Pagamento.PagamentoUpdateDTO;
import com.example.demo.Exception.ApiError;
import com.example.demo.Service.EnderecoService;
import com.example.demo.Service.PagamentoService;
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
@RequestMapping("/pagamento")
@Tag(name = "Pagamentos", description = "API para gerenciamento de pagamentos")
public class PagamentoController {

    private final PagamentoService pagamentoService;

    public PagamentoController(PagamentoService pagamentoService) {
        this.pagamentoService = pagamentoService;
    }

    @GetMapping("/{id}")
    @Operation(summary = "Retornar um pagamento", description = "Retorna pagamento pelo ID")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Sucesso"),
            @ApiResponse(responseCode = "500", description = "Erro interno", content = @Content(schema = @Schema(implementation = ApiError.class)))
    })
    public PagamentoDTO findById(@PathVariable Long id) {
        return pagamentoService.findById(id);
    }

    @GetMapping
    @Operation(summary = "Listar pagamentos", description = "Retorna todos os pagamentos criados")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Sucesso"),
            @ApiResponse(responseCode = "500", description = "Erro interno", content = @Content(schema = @Schema(implementation = ApiError.class)))
    })
    public List<PagamentoDTO> findAll() {
        return pagamentoService.findAll();
    }

    @PatchMapping("/{id}")
    @Operation(summary = "Atualizar pagamento", description = "Atualiza os dados de um pagamento existente")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Pagamento atualizado com sucesso"),
            @ApiResponse(responseCode = "404", description = "Pagamento não encontrado", content = @Content(schema = @Schema(implementation = ApiError.class)))
    })
    public PagamentoDTO update(@PathVariable Long id, @RequestBody @Valid PagamentoUpdateDTO pagamento) {
        return pagamentoService.update(id, pagamento);
    }

    @DeleteMapping("/{id}")
    @Operation(summary = "Deletar pagamento", description = "Remove um pagamento pelo ID")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "204", description = "Pagamento deletado com sucesso"),
            @ApiResponse(responseCode = "404", description = "Pagamento não encontrado", content = @Content(schema = @Schema(implementation = ApiError.class)))
    })
    public void delete(@PathVariable Long id) {
        pagamentoService.delete(id);
    }

}