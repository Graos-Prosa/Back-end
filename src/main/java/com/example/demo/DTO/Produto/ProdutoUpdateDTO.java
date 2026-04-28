package com.example.demo.DTO.Produto;

import io.swagger.v3.oas.annotations.media.Schema;

@Schema(description = "DTO para atualização de produto")
public record ProdutoUpdateDTO(
        @Schema(description = "Título do produto", example = "Café Arábica")
        String titulo,
        @Schema(description = "Descrição", example = "Nova descrição")
        String descricao,
        @Schema(description = "Categoria", example = "CAFE")
        String categoria
) {}