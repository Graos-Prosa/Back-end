package com.example.demo.Model;

import com.example.demo.DTO.ProdutoCreateDTO;
import jakarta.persistence.*;
import lombok.*;
import java.math.BigDecimal;
import java.math.BigInteger;

@Entity
@Table(name = "produto")
@NoArgsConstructor
@AllArgsConstructor
@Getter @Setter
@ToString(exclude = "idProduto")

public class Produto {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_produto", nullable = false , length = 100)
    private Long idProduto;
    @Column(name = "titulo", nullable = false , length = 100)
    private String titulo;
    @Column(name = "descricao", nullable = false , length = 512)
    private String descricao;
    @Column(name = "imagem", nullable = false)
    private String imagemUrl;
    @Column(name = "tipo", nullable = false , length = 50)
    private String tipo;
    @Column(name = "preco", nullable = false , precision = 10 , scale = 2)
    private BigDecimal preco;
    @Column(name = "quantidade", nullable = false)
    private Integer quantidade;

    public Produto(ProdutoCreateDTO produto) {
        this.titulo = produto.titulo();
        this.descricao = produto.descricao();
        this.tipo = produto.tipo();
        this.imagemUrl = produto.imagemUrl();
        this.preco = produto.preco();
        this.quantidade = produto.quantidade();
    }
}
