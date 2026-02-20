package com.example.demo.Model;

import jakarta.persistence.*;
import lombok.*;

import java.math.BigDecimal;
import java.math.BigInteger;

@Entity
@Table(name = "cupom")
@NoArgsConstructor
@AllArgsConstructor
@Getter @Setter
@ToString(exclude = "idCupom")

public class Cupom {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_cupom", nullable = false)
    @Getter private BigInteger idCupom;
    @Column(name = "codigo", nullable = false , length = 50)
    private String codigo;
    @Column(name = "valor", nullable = false , precision = 10 , scale = 2)
    private BigDecimal valor;
    @Column(name = "tipo", nullable = false , length = 50)
    private String tipo;
    @Column(name = "estado", nullable = false , length = 50)
    private enumCupom estado;
}
