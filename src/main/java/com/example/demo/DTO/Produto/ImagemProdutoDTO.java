package com.example.demo.DTO.Produto;

import com.example.demo.Model.ImagemProduto;
import io.swagger.v3.oas.annotations.media.Schema;

@Schema(description = "DTO de retorno de imagem do produto")
public record ImagemProdutoDTO(
        @Schema(description = "ID da imagem", example = "1")
        Long id,
        @Schema(description = "URL da imagem", example = "https://site.com/imagem.jpg")
        String urlImagem,
        @Schema(description = "Ordem de exibição", example = "0")
        Integer ordem,
        @Schema(description = "ID da variante associada", example = "1")
        Long idVariante
) {
    public ImagemProdutoDTO(ImagemProduto imagem) {
        this(
                imagem.getId(),
                imagem.getUrlImagem(),
                imagem.getOrdem(),
                imagem.getVariante() != null ? imagem.getVariante().getIdVariante() : null
        );
    }
}