package com.example.demo.DTO.Pedido;

import com.example.demo.Model.enumPedido;
import io.swagger.v3.oas.annotations.media.Schema;

import java.math.BigDecimal;

@Schema(description = "DTO para atualização de pedido")
public record PedidoUpdateDTO(
        @Schema(description = "ID do cupom aplicado", example = "3")
        Long idCupom,
        @Schema(
                description = """
                        Estado do pedido:
                        - PROCESSANDO: pedido em andamento
                        - FINALIZADO: pedido concluído
                        """,
                allowableValues = {"PROCESSANDO","FINALIZADO"},
                example = "FINALIZADO"
        )
        String estado,
        @Schema(description = "Desconto aplicado", example = "15.00")
        BigDecimal desconto,
        @Schema(description = "Valor total do pedido", example = "120.00")
        BigDecimal valorTotal,
        @Schema(description = "Valor final do pedido", example = "105.00")
        BigDecimal valorFinal
) {}