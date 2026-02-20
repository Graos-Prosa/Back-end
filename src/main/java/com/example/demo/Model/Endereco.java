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
    @Getter private BigInteger idEndereco;
    @Column(name = "id_usuario", nullable = false)
    private BigInteger idUsuario;
    @Column(name = "logradouro", nullable = false)
    private String logradouro;
    @Column(name = "numero", nullable = false)
    private Integer numero;
    @Column(name = "complemento", nullable = false , length = )
    private String complemento;
    @Column(name = "referencia", nullable = false)
    private String referencia;
    @Column(name = "bairro", nullable = false)
    private String bairro;
    @Column(name = "cep", nullable = false)
    private String cep;
    @Column(name = "cidade", nullable = false)
    private String cidade;
    @Column(name = "estado", nullable = false)
    private String estado;
    @Column(name = "pais", nullable = false)
    private String pais;
}
