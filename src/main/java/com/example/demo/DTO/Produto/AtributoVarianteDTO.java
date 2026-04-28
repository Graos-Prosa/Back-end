package com.example.demo.DTO.Produto;

import com.example.demo.Model.AtributoVariante;
import io.swagger.v3.oas.annotations.media.Schema;

@Schema(description = "DTO de retorno de atributo da variante")
public record AtributoVarianteDTO(
        @Schema(description = "ID do atributo", example = "1")
        Long id,
        @Schema(description = "Nome do atributo", example = "Quantidade gramas")
        String nomeAtributo,
        @Schema(description = "Valor do atributo", example = "100")
        String valorAtributo
) {
    public AtributoVarianteDTO(AtributoVariante atributo) {
        this(
                atributo.getId(),
                atributo.getNomeAtributo(),
                atributo.getValorAtributo()
        );
    }
}