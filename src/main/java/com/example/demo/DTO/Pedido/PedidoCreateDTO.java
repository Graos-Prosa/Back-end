package com.example.demo.DTO.Pedido;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.DecimalMin;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Schema(description = "DTO para criação de pedido")
public record PedidoCreateDTO(
        @NotNull(message = "O Id do Usuário não pode ser nulo")
        @Schema(description = "ID do usuário que está realizando o pedido", example = "1")
        Long idUsuario,
        @NotNull(message = "O Id do Endereço não pode ser nulo")
        @Schema(description = "ID do endereço de entrega", example = "5")
        Long idEndereco,
        @Schema(description = "ID do cupom aplicado (opcional)", example = "2")
        Long idCupom,
        @NotBlank(message = "O estado do pedido precisa ser válido.")
        @Schema(
                description = """
                        Estado do pedido:
                        - PROCESSANDO: pedido em andamento
                        - FINALIZADO: pedido concluído
                        """,
                example = "PROCESSANDO"
        )
        String estado,
        @Schema(description = "Valor de desconto aplicado", example = "10.00")
        BigDecimal desconto,
        @NotNull(message = "O valor total não pode ser nulo")
        @DecimalMin(value = "0.0", inclusive = true)
        @Schema(description = "Valor total do pedido antes do desconto", example = "100.00")
        BigDecimal valorTotal,
        @NotNull(message = "O valor final não pode ser nulo")
        @DecimalMin(value = "0.0", inclusive = true)
        @Schema(description = "Valor final do pedido após desconto", example = "90.00")
        BigDecimal valorFinal
) {}