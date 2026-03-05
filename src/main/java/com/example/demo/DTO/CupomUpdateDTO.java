package com.example.demo.DTO;

import com.example.demo.Model.enumCupom;
import java.math.BigDecimal;

public record CupomUpdateDTO (
        String codigo,
        BigDecimal valor,
        String tipo,
        enumCupom estado
) {}
