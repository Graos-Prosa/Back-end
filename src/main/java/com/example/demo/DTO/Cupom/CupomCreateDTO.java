package com.example.demo.DTO.Cupom;

import com.example.demo.Model.enumCupom;
import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

import java.math.BigDecimal;

@Schema(description = "DTO para criação de cupom")
public record CupomCreateDTO(
        @NotBlank(message = "Código do cupom precisa ser válido.")
        @Schema(description = "Código único do cupom", example = "PROMO10")
        String codigo,
        @NotNull(message = "O valor do cupom não pode ser nulo")
        @Min(value = 1, message = "O valor precisa ser maior que zero.")
        @Schema(description = "Valor do desconto do cupom", example = "10.00")
        BigDecimal valor,
        @NotBlank(message = "O tipo do cupom precisa ser válido.")
        @Schema(description = "Tipo do cupom (PORCENTAGEM ou VALOR_FIXO)", example = "PORCENTAGEM")
        String tipo,
        @NotNull(message = "O estado do cupom precisa ser válido.")
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
) {}
