package com.example.demo.DTO.Produto;

import java.math.BigDecimal;

public record ProdutoUpdateDTO (
        String titulo,
        String descricao,
        String imagemUrl,
        String tipo,
        BigDecimal preco,
        Integer quantidade
) {}
