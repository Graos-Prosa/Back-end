package com.example.demo.Model;

import jakarta.persistence.*;
import lombok.*;

import java.math.BigDecimal;
import java.math.BigInteger;

@Entity
@Table(name = "item")
@NoArgsConstructor
@AllArgsConstructor
@ToString(exclude = "id_item")

public class Item {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Getter BigInteger id_item;
    @Getter @Setter BigInteger id_produto;
    @Getter @Setter private BigInteger id_pedido;
    @Getter @Setter private Integer quantidade;
    @Getter @Setter private BigDecimal subtotal;
}
