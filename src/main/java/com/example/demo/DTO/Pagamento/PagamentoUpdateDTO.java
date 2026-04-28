package com.example.demo.DTO.Pagamento;

import com.example.demo.Model.enumPagamento;
import io.swagger.v3.oas.annotations.media.Schema;

import java.time.LocalDateTime;

@Schema(description = "DTO para atualização de pagamento")
public record PagamentoUpdateDTO(
        @Schema(
                description = """
                        Status do pagamento:
                        - PENDENTE: pagamento ainda não realizado
                        - PAGO: pagamento confirmado
                        - CANCELADO: pagamento cancelado
                        """,
                allowableValues = {"PENDENTE", "PAGO", "CANCELADO"},
                example = "PAGO"
        )
        enumPagamento status,
        @Schema(description = "Data de pagamento", example = "2026-04-28T10:35:00")
        LocalDateTime dataPagamento
) {}