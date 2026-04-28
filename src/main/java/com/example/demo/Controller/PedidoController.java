package com.example.demo.Controller;

import com.example.demo.DTO.Item.ItemDTO;
import com.example.demo.DTO.Pagamento.PagamentoDTO;
import com.example.demo.DTO.Pedido.PedidoCreateDTO;
import com.example.demo.DTO.Pedido.PedidoDTO;
import com.example.demo.DTO.Pedido.PedidoUpdateDTO;
import com.example.demo.Exception.ApiError;
import com.example.demo.Service.ItemService;
import com.example.demo.Service.PagamentoService;
import com.example.demo.Service.PedidoService;
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
@RequestMapping("/pedido")
@Tag(name = "Pedidos", description = "API para gerenciamento de pedidos")
public class PedidoController {

    private final PedidoService pedidoService;
    private final ItemService itemService;
    private final PagamentoService pagamentoService;

    public PedidoController(PedidoService pedidoService, ItemService itemService, PagamentoService pagamentoService) {
        this.pedidoService = pedidoService;
        this.itemService = itemService;
        this.pagamentoService = pagamentoService;
    }

    @GetMapping("/{id}")
    @Operation(summary = "Retornar um pedido", description = "Retorna pedido pelo ID")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Sucesso"),
            @ApiResponse(responseCode = "500", description = "Erro interno", content = @Content(schema = @Schema(implementation = ApiError.class)))
    })
    public PedidoDTO findById(@PathVariable Long id) {
        return pedidoService.findById(id);
    }

    @GetMapping
    @Operation(summary = "Listar pedidos", description = "Retorna todos os pedidos efetuados")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Sucesso"),
            @ApiResponse(responseCode = "500", description = "Erro interno", content = @Content(schema = @Schema(implementation = ApiError.class)))
    })
    public List<PedidoDTO> findAll() {
        return pedidoService.findAll();
    }

    @PostMapping
    @Operation(summary = "Efetuar pedido")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "201", description = "Pedido criado com sucesso"),
            @ApiResponse(responseCode = "400", description = "Dados inválidos", content = @Content(schema = @Schema(implementation = ApiError.class))),
            @ApiResponse(responseCode = "500", description = "Erro interno", content = @Content(schema = @Schema(implementation = ApiError.class)))
    })
    public PedidoDTO create(@RequestBody @Valid PedidoCreateDTO pedido) {
        return pedidoService.save(pedido);
    }

    @PatchMapping("/{id}")
    @Operation(summary = "Atualizar pedido", description = "Atualiza os dados de um pedido existente")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Pedido atualizado com sucesso"),
            @ApiResponse(responseCode = "404", description = "Pedido não encontrado", content = @Content(schema = @Schema(implementation = ApiError.class)))
    })
    public PedidoDTO update(@PathVariable Long id, @RequestBody @Valid PedidoUpdateDTO pedido) {
        return pedidoService.update(id, pedido);
    }

    //implementar autenticação de delete
    @DeleteMapping("/{id}")
    @Operation(summary = "Deletar pedido", description = "Remove um pedido pelo ID")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "204", description = "Pedido deletado com sucesso"),
            @ApiResponse(responseCode = "404", description = "Pedido não encontrado", content = @Content(schema = @Schema(implementation = ApiError.class)))
    })
    public void delete(@PathVariable Long id) {
        pedidoService.delete(id);
    }

    @GetMapping("/{id}/itens")
    @Operation(summary = "Listar itens de pedido", description = "Retorna todos os itens cadastrados de um pedido pelo ID")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Sucesso"),
            @ApiResponse(responseCode = "500", description = "Erro interno", content = @Content(schema = @Schema(implementation = ApiError.class)))
    })
    public List<ItemDTO> findAllItem(@PathVariable Long id) {
        return itemService.buscarPorPedido(id);
    }

    @GetMapping("/{id}/pagamento")
    @Operation(summary = "Retornar pagamento do pedido", description = "Retorna pagamento do pedido pelo ID")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Sucesso"),
            @ApiResponse(responseCode = "500", description = "Erro interno", content = @Content(schema = @Schema(implementation = ApiError.class)))
    })
    public PagamentoDTO findPagamento(@PathVariable Long id) {
        return pagamentoService.buscarPorPedido(id);
    }
}
