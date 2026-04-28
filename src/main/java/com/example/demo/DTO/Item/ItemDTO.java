package com.example.demo.DTO.Item;

import com.example.demo.Model.Item;
import io.swagger.v3.oas.annotations.media.Schema;

import java.math.BigDecimal;

@Schema(description = "DTO de retorno do item do pedido")
public record ItemDTO(
        @Schema(description = "ID do item", example = "1")
        Long id,
        @Schema(description = "ID do produto", example = "5")
        Long idProduto,
        @Schema(description = "ID da variante", example = "2")
        Long idVariante,
        @Schema(description = "ID do pedido", example = "10")
        Long idPedido,
        @Schema(description = "Quantidade do item", example = "2")
        Integer quantidade,
        @Schema(description = "Subtotal do item", example = "49.90")
        BigDecimal subtotal
) {
    public ItemDTO(Item item) {
        this(
                item.getIdItem(),
                item.getVariante().getProduto().getIdProduto(),
                item.getVariante().getIdVariante(),
                item.getPedido().getIdPedido(),
                item.getQuantidade(),
                item.getSubtotal()
        );
    }
}