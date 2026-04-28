package com.example.demo.DTO.Pagamento;

import com.example.demo.Model.Pagamento;
import com.example.demo.Model.enumPagamento;
import io.swagger.v3.oas.annotations.media.Schema;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Schema(description = "DTO de retorno do pagamento")
public record PagamentoDTO(
        @Schema(description = "ID do pagamento", example = "1")
        Long id,
        @Schema(description = "ID do pedido", example = "10")
        Long idPedido,
        @Schema(
                description = """
                        Status do pagamento:
                        - PENDENTE: pagamento ainda não realizado
                        - PAGO: pagamento confirmado
                        - CANCELADO: pagamento cancelado
                        """,
                example = "PENDENTE"
        )
        enumPagamento status,
        @Schema(description = "Valor do pagamento", example = "99.90")
        BigDecimal valor,
        @Schema(description = "Data de criação do pagamento", example = "2026-04-28T10:30:00")
        LocalDateTime dataCriacao,
        @Schema(description = "Data em que o pagamento foi realizado", example = "2026-04-28T10:35:00")
        LocalDateTime dataPagamento
) {
    public PagamentoDTO(Pagamento pagamento) {
        this(
                pagamento.getIdPagamento(),
                pagamento.getPedido().getIdPedido(),
                pagamento.getStatus(),
                pagamento.getValor(),
                pagamento.getDataCriacao(),
                pagamento.getDataPagamento()
        );
    }
}