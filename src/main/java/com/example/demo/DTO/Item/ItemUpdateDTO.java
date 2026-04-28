package com.example.demo.DTO.Item;

import com.example.demo.Model.Endereco;
import io.swagger.v3.oas.annotations.media.Schema;

import java.math.BigDecimal;

@Schema(description = "DTO para atualização de item do pedido")
public record ItemUpdateDTO(
        @Schema(description = "Quantidade do item", example = "3")
        Integer quantidade,
        @Schema(description = "Subtotal atualizado do item", example = "74.85")
        BigDecimal subtotal
) {}