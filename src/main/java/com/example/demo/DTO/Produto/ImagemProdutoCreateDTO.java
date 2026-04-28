package com.example.demo.DTO.Produto;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

@Schema(description = "DTO para criação de imagem do produto")
public record ImagemProdutoCreateDTO(
        @NotBlank
        @Schema(description = "URL da imagem", example = "https://site.com/imagem.jpg")
        String urlImagem,
        @NotNull
        @Min(0)
        @Schema(description = "Ordem de exibição da imagem", example = "0")
        Integer ordem
) {}
