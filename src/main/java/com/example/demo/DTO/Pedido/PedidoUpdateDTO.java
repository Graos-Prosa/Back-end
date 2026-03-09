package com.example.demo.DTO.Pedido;

import java.math.BigDecimal;

public record PedidoUpdateDTO(
        Long idCupom,
        String estado,
        BigDecimal desconto,
        BigDecimal valorTotal,
        BigDecimal valorFinal
) {}