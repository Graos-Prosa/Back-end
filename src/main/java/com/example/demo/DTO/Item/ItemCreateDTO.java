package com.example.demo.DTO.Item;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

import java.math.BigDecimal;

@Schema(description = "DTO para criação de item de pedido")
public record ItemCreateDTO(
        @NotNull(message = "O Id da Variante não pode ser nulo")
        @Schema(description = "ID da variante do produto", example = "1")
        Long idVariante,
        @NotNull(message = "O Id do Pedido não pode ser nulo")
        @Schema(description = "ID do pedido", example = "10")
        Long idPedido,
        @NotNull(message = "O valor da quantidade não pode ser nulo")
        @Min(value = 0, message = "O valor precisa ser maior ou igual a zero.")
        @Schema(description = "Quantidade do item", example = "2")
        Integer quantidade,
        @NotNull(message = "O subtotal não pode ser nulo")
        @Min(value = 0, message = "O valor precisa ser maior ou igual a zero.")
        @Schema(description = "Subtotal do item", example = "49.90")
        BigDecimal subtotal
) {}