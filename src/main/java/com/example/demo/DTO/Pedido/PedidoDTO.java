package com.example.demo.DTO.Pedido;
import com.example.demo.Model.Pedido;
import io.swagger.v3.oas.annotations.media.Schema;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Schema(description = "DTO de retorno do pedido")
public record PedidoDTO(
        @Schema(description = "ID do pedido", example = "1")
        Long id,
        @Schema(description = "ID do usuário", example = "1")
        Long idUsuario,
        @Schema(description = "ID do endereço", example = "5")
        Long idEndereco,
        @Schema(description = "ID do cupom aplicado", example = "2")
        Long idCupom,
        @Schema(description = "Estado do pedido", example = "CRIADO")
        String estado,
        @Schema(description = "Desconto aplicado", example = "10.00")
        BigDecimal desconto,
        @Schema(description = "Data do pedido", example = "2026-04-28T10:30:00")
        LocalDateTime dataPedido,
        @Schema(description = "Valor total do pedido", example = "100.00")
        BigDecimal valorTotal,
        @Schema(description = "Valor final do pedido", example = "90.00")
        BigDecimal valorFinal,
        @Schema(description = "Status do pagamento", example = "PENDENTE")
        String statusPagamento
) {
    public PedidoDTO(Pedido pedido) {
        this(
                pedido.getIdPedido(),
                pedido.getUsuario().getIdUsuario(),
                pedido.getEndereco().getIdEndereco(),
                pedido.getCupom() != null ? pedido.getCupom().getIdCupom() : null,
                pedido.getEstado(),
                pedido.getDesconto(),
                pedido.getDataPedido(),
                pedido.getValorTotal(),
                pedido.getValorFinal(),
                pedido.getPagamento() != null ? pedido.getPagamento().getStatus().name() : null
        );
    }
}