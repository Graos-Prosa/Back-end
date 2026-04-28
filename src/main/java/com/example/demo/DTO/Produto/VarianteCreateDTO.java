package com.example.demo.DTO.Produto;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.DecimalMin;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

import java.math.BigDecimal;
import java.util.List;

@Schema(description = "DTO para criação de variante de produto")
public record VarianteCreateDTO(
        @NotBlank(message = "SKU deve ser válido.")
        @Schema(description = "Código SKU da variante", example = "CAF-001-ARB")
        String sku,
        @NotNull(message = "O preço não pode ser nulo.")
        @DecimalMin(value = "0.0", inclusive = false)
        @Schema(description = "Preço da variante", example = "59.90")
        BigDecimal preco,
        @NotNull(message = "O estoque não pode ser nulo.")
        @Min(value = 0)
        @Schema(description = "Quantidade em estoque", example = "100")
        Integer estoque,
        @Schema(description = "Atributos da variante (ex: quantidade grãos, tipo de café...)")
        List<AtributoVarianteCreateDTO> atributos,
        @Schema(description = "Imagens da variante")
        List<ImagemProdutoCreateDTO> imagens
) {}