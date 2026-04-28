package com.example.demo.DTO.Produto;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;

import java.util.List;

@Schema(description = "DTO para criação de produto")
public record ProdutoCreateDTO(
        @NotBlank(message = "Título deve ser válido.")
        @Schema(description = "Título do produto", example = "Café Arábica")
        String titulo,
        @NotBlank(message = "Descrição deve ser válida.")
        @Schema(description = "Descrição do produto", example = "Café 100% arábica, da variedade Catuaí 144, produzido na Chapada Diamantina...")
        String descricao,
        @NotBlank(message = "Categoria deve ser válida.")
        @Schema(description = "Categoria do produto", example = "CAFE")
        String categoria,
        @Schema(description = "Lista de imagens do produto")
        List<ImagemProdutoCreateDTO> imagens,
        @NotEmpty(message = "O produto precisa ter pelo menos uma variante.")
        @Schema(description = "Lista de variantes do produto")
        List<VarianteCreateDTO> variantes
) {}