package com.example.demo.DTO.Produto;

import com.example.demo.Model.Produto;
import io.swagger.v3.oas.annotations.media.Schema;

import java.util.ArrayList;
import java.util.List;

@Schema(description = "DTO de retorno do produto")
public record ProdutoDTO(
        @Schema(description = "ID do produto", example = "1")
        Long id,
        @Schema(description = "Título do produto", example = "Café Arábica")
        String titulo,
        @Schema(description = "Descrição", example = "Café 100% arábica, da variedade Catuaí 144, produzido na Chapada Diamantina...")
        String descricao,
        @Schema(description = "Categoria", example = "CAFE")
        String categoria,
        @Schema(description = "Imagens do produto")
        List<ImagemProdutoDTO> imagens,
        @Schema(description = "Variantes do produto")
        List<VarianteDTO> variantes
) {
    public ProdutoDTO(Produto produto) {
        this(
                produto.getIdProduto(),
                produto.getTitulo(),
                produto.getDescricao(),
                produto.getCategoria(),
                produto.getImagens() != null
                        ? produto.getImagens().stream().map(ImagemProdutoDTO::new).toList()
                        : new ArrayList<>(),
                produto.getVariantes() != null
                        ? produto.getVariantes().stream().map(VarianteDTO::new).toList()
                        : new ArrayList<>()
        );
    }
}