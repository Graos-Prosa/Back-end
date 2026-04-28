package com.example.demo.DTO.Cupom;

import com.example.demo.Model.Cupom;
import com.example.demo.Model.enumCupom;
import io.swagger.v3.oas.annotations.media.Schema;

import java.math.BigDecimal;

@Schema(description = "DTO de retorno do cupom")
public record CupomDTO(
        @Schema(description = "ID do cupom", example = "1")
        Long id,
        @Schema(description = "Código do cupom", example = "PROMO10")
        String codigo,
        @Schema(description = "Valor do desconto", example = "10.00")
        BigDecimal valor,
        @Schema(description = "Tipo do cupom", example = "PORCENTAGEM")
        String tipo,
        @Schema(
                description = """
                        Estado do cupom:
                        - ATIVO: pode ser utilizado
                        - APLICADO: já foi aplicado em um pedido
                        - RESGATADO: já foi utilizado/consumido
                        - CANCELADO: foi invalidado manualmente
                        - EXPIRADO: passou da data de validade
                        """,
                allowableValues = {"ATIVO", "APLICADO", "RESGATADO", "CANCELADO","EXPIRADO"},
                example = "ATIVO"
        )
        enumCupom estado
) {
    public CupomDTO(Cupom cupom) {
        this(
                cupom.getIdCupom(),
                cupom.getCodigo(),
                cupom.getValor(),
                cupom.getTipo(),
                cupom.getEstado()
        );
    }
}