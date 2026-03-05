package com.example.demo.DTO;

import com.example.demo.Model.Produto;

import java.math.BigDecimal;

public record ProdutoDTO (
        Long id,
        String titulo,
        String descricao,
        String imagemUrl,
        String tipo,
        BigDecimal preco,
        Integer quantidade
) {
    public ProdutoDTO(Produto produto) {
        this(
                produto.getIdProduto(),
                produto.getTitulo(),
                produto.getDescricao(),
                produto.getImagemUrl(),
                produto.getTipo(),
                produto.getPreco(),
                produto.getQuantidade()
        );
    }
}
