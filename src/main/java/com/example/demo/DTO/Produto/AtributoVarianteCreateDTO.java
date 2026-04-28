package com.example.demo.DTO.Produto;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotBlank;

@Schema(description = "DTO para criação de atributo da variante")
public record AtributoVarianteCreateDTO(
        @NotBlank
        @Schema(description = "Nome do atributo", example = "Quantidade gramas")
        String nomeAtributo,
        @NotBlank
        @Schema(description = "Valor do atributo", example = "100")
        String valorAtributo
) {}