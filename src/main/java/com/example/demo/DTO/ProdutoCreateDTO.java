package com.example.demo.DTO;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

import java.math.BigDecimal;

public record ProdutoCreateDTO (
        @NotBlank(message = "Título deve ser válido.")
        String titulo,
        @NotBlank(message = "Descrição deve ser válida.")
        String descricao,
        @NotNull(message = "Imagem não pode ser nula.")
        String imagemUrl,
        @NotBlank(message = "Tipo deve ser válido.")
        String tipo,
        @NotNull(message = "O preço não pode ser nulo.") @Min(value = 1, message = "O preço deve ser maior que zero.")
        BigDecimal preco,
        @NotNull(message = "A quantidade não pode ser nula.") @Min(value = 1, message = "A quantidade deve ser maior que zero.")
        Integer quantidade

) {}

