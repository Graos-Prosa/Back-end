package com.example.demo.Model;

import jakarta.persistence.*;
import lombok.*;
import java.math.BigDecimal;
import java.math.BigInteger;

@Entity
@Table(name = "produto")
@NoArgsConstructor
@AllArgsConstructor
@ToString(exclude = "id_produto")

public class Produto {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Getter private BigInteger id_produto;
    @Getter @Setter String titulo;
    @Getter @Setter private String descricao;
    @Getter @Setter private BigDecimal preco;
    @Getter @Setter private Integer quantidade;
}
