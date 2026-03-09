package com.example.demo.DTO.Cupom;

import com.example.demo.Model.Cupom;
import com.example.demo.Model.enumCupom;

import java.math.BigDecimal;

public record CupomDTO (
        Long id,
        String codigo,
        BigDecimal valor,
        String tipo,
        enumCupom estado
) {
    public CupomDTO(Cupom cupom) {
        this(
            cupom.getIdCupom(),
            cupom.getCodigo(),
            cupom.getValor(),
            cupom.getTipo(),
            cupom.getEstado()
        );
    }
}
