package com.example.demo.Model;

import jakarta.persistence.*;
import lombok.*;
import java.math.BigInteger;

@Entity
@Table(name = "endereco")
@NoArgsConstructor
@AllArgsConstructor
@Getter @Setter
@ToString(exclude = "idEndereco")

public class Endereco {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_endereco", nullable = false)
    private BigInteger idEndereco;
    @OneToOne(optional = false)
    @JoinColumn(nullable = false, name = "id_usuario")
    private Usuario usuario;
    @Column(name = "logradouro", nullable = false , length = 150)
    private String logradouro;
    @Column(name = "numero", nullable = false)
    private Integer numero;
    @Column(name = "complemento", nullable = false , length = 100)
    private String complemento;
    @Column(name = "referencia", nullable = false , length = 100)
    private String referencia;
    @Column(name = "bairro", nullable = false , length = 100)
    private String bairro;
    @Column(name = "cep", nullable = false , length = 9)
    private String cep;
    @Column(name = "cidade", nullable = false , length = 50)
    private String cidade;
    @Column(name = "estado", nullable = false , length = 50)
    private String estado;
    @Column(name = "pais", nullable = false , length = 50)
    private String pais;
}
