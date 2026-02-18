package com.example.demo.Model;

import jakarta.persistence.*;
import lombok.*;

import java.math.BigDecimal;
import java.math.BigInteger;

@Entity
@Table(name = "cupom")
@NoArgsConstructor
@AllArgsConstructor
@ToString(exclude = "id_cupom")

public class Cupom {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Getter private BigInteger id_cupom;
    @Getter @Setter private String codigo;
    @Getter @Setter private BigDecimal valor;
    @Getter @Setter private String tipo;
    @Getter @Setter private enumCupom estado;
}
