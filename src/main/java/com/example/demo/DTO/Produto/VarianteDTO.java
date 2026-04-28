package com.example.demo.DTO.Produto;

import com.example.demo.Model.Variante;
import io.swagger.v3.oas.annotations.media.Schema;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

@Schema(description = "DTO de retorno da variante")
public record VarianteDTO(
        @Schema(description = "ID da variante", example = "1")
        Long id,
        @Schema(description = "SKU", example = "CAF-001-ARB")
        String sku,
        @Schema(description = "Preço", example = "59.90")
        BigDecimal preco,
        @Schema(description = "Estoque", example = "100")
        Integer estoque,
        @Schema(description = "Atributos da variante (ex: quantidade grãos, tipo de café...)")
        List<AtributoVarianteDTO> atributos,
        @Schema(description = "Imagens da variante")
        List<ImagemProdutoDTO> imagens
) {
    public VarianteDTO(Variante variante) {
        this(
                variante.getIdVariante(),
                variante.getSku(),
                variante.getPreco(),
                variante.getEstoque(),
                variante.getAtributos() != null
                        ? variante.getAtributos().stream().map(AtributoVarianteDTO::new).toList()
                        : new ArrayList<>(),
                new ArrayList<>()
        );
    }
}