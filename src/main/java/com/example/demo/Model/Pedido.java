package com.example.demo.Model;

import jakarta.persistence.*;
import lombok.*;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.time.LocalDateTime;

@Entity
@Table(name = "pedido")
@NoArgsConstructor
@AllArgsConstructor
@ToString(exclude = "id_pedido")

public class Pedido {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Getter private BigInteger id_pedido;
    @Getter @Setter private BigInteger id_usuario;
    @Getter @Setter BigInteger id_cupom;
    @Getter @Setter private String estado;
    @Getter @Setter private BigDecimal desconto;
    @Getter @Setter private LocalDateTime data_pedido;
    @Getter @Setter private BigDecimal valor_total;
    @Getter @Setter private BigDecimal valor_final;
}
