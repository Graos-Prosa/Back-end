package com.example.demo.DTO.Pagamento;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.DecimalMin;
import jakarta.validation.constraints.NotNull;

import java.math.BigDecimal;

@Schema(description = "DTO para criação de pagamento")
public record PagamentoCreateDTO(
        @NotNull(message = "O Id do Pedido não pode ser nulo")
        @Schema(description = "ID do pedido associado ao pagamento", example = "10")
        Long idPedido,
        @NotNull(message = "O valor não pode ser nulo")
        @DecimalMin(value = "0.0", inclusive = true, message = "O valor precisa ser maior ou igual a zero.")
        @Schema(description = "Valor do pagamento", example = "99.90")
        BigDecimal valor
) {}