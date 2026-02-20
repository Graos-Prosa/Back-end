package com.example.demo.Model;

import jakarta.persistence.*;
import lombok.*;

import java.math.BigDecimal;
import java.math.BigInteger;

@Entity
@Table(name = "item")
@NoArgsConstructor
@AllArgsConstructor
@Getter @Setter
@ToString(exclude = "idItem")

public class Item {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_item", nullable = false)
    @Getter private BigInteger idItem;
    @Column(name = "id_produto", nullable = false)
    private BigInteger idProduto;
    @Column(name = "id_pedido", nullable = false)
    private BigInteger idPedido;
    @Column(name = "quantidade", nullable = false)
    private Integer quantidade;
    @Column(name = "subtotal", nullable = false , precision = 10 , scale = 2)
    private BigDecimal subtotal;
}
