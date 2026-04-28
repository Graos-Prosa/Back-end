package com.example.demo.DTO.Cupom;

import com.example.demo.Model.enumCupom;
import io.swagger.v3.oas.annotations.media.Schema;

import java.math.BigDecimal;

@Schema(description = "DTO para atualização de cupom")
public record CupomUpdateDTO(
        @Schema(description = "Código do cupom", example = "PROMO20")
        String codigo,
        @Schema(description = "Valor do cupom", example = "20.00")
        BigDecimal valor,
        @Schema(description = "Tipo do cupom", example = "VALOR_FIXO")
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
                example = "INATIVO"
        )
        enumCupom estado
) {}