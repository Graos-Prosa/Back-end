package com.example.demo.DTO.Cupom;

import com.example.demo.Model.enumCupom;
import java.math.BigDecimal;

public record CupomUpdateDTO (
        String codigo,
        BigDecimal valor,
        String tipo,
        enumCupom estado
) {}
