package com.example.demo.Model;

import jakarta.persistence.*;
import lombok.*;
import java.math.BigDecimal;
import java.math.BigInteger;

@Entity
@Table(name = "produto")
@NoArgsConstructor
@AllArgsConstructor
@Getter @Setter
@ToString(exclude = "id_produto")

public class Produto {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Getter private BigInteger id_produto;
    @Column(name = "titulo")
    private String titulo;
    private String descricao;
    private String tipo;
    private BigDecimal preco;
    private Integer quantidade;
}
