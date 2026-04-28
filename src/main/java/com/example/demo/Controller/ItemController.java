package com.example.demo.Controller;

import com.example.demo.DTO.Item.ItemCreateDTO;
import com.example.demo.DTO.Item.ItemDTO;
import com.example.demo.DTO.Item.ItemUpdateDTO;
import com.example.demo.Exception.ApiError;
import com.example.demo.Service.ItemService;
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
@RequestMapping("/item")
@Tag(name = "Itens", description = "API para gerenciamento de itens")
public class ItemController {

    private final ItemService itemService;

    public ItemController(ItemService itemService) {
        this.itemService = itemService;
    }

    @GetMapping("/{id}")
    @Operation(summary = "Retornar um item", description = "Retorna item pelo ID")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Sucesso"),
            @ApiResponse(responseCode = "500", description = "Erro interno", content = @Content(schema = @Schema(implementation = ApiError.class)))
    })
    public ItemDTO findById(@PathVariable Long id) {
        return itemService.findById(id);
    }

    @GetMapping
    @Operation(summary = "Listar itens", description = "Retorna todos os itens cadastrados")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Sucesso"),
            @ApiResponse(responseCode = "500", description = "Erro interno", content = @Content(schema = @Schema(implementation = ApiError.class)))
    })
    public List<ItemDTO> findAll() {
        return itemService.findAll();
    }

    @PostMapping
    @Operation(summary = "Cadastrar item")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "201", description = "Item criado com sucesso"),
            @ApiResponse(responseCode = "400", description = "Dados inválidos", content = @Content(schema = @Schema(implementation = ApiError.class))),
            @ApiResponse(responseCode = "500", description = "Erro interno", content = @Content(schema = @Schema(implementation = ApiError.class)))
    })
    public ItemDTO create(@RequestBody @Valid ItemCreateDTO item) {
        return itemService.save(item);
    }

    @PatchMapping("/{id}")
    @Operation(summary = "Atualizar item", description = "Atualiza os dados de um item existente")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Item atualizado com sucesso"),
            @ApiResponse(responseCode = "404", description = "Item não encontrado", content = @Content(schema = @Schema(implementation = ApiError.class)))
    })
    public ItemDTO update(@PathVariable Long id, @RequestBody @Valid ItemUpdateDTO item) {
        return itemService.update(id, item);
    }

    //implementar autenticação de delete
    @DeleteMapping("/{id}")
    @Operation(summary = "Deletar item", description = "Remove um Item pelo ID")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "204", description = "Item deletado com sucesso"),
            @ApiResponse(responseCode = "404", description = "Item não encontrado", content = @Content(schema = @Schema(implementation = ApiError.class)))
    })
    public void delete(@PathVariable Long id) {
        itemService.delete(id);
    }

}
