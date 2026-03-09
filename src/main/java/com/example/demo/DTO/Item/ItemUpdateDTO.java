package com.example.demo.DTO.Item;

import com.example.demo.Model.Endereco;

import java.math.BigDecimal;

public record ItemUpdateDTO (
        Integer quantidade,
        BigDecimal subtotal
) {}