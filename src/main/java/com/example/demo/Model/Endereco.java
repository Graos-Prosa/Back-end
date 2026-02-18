package com.example.demo.Model;

import jakarta.persistence.*;
import lombok.*;

import java.math.BigInteger;

@Entity
@Table(name = "endereco")
@NoArgsConstructor
@AllArgsConstructor
@ToString(exclude = "id_endereco")

public class Endereco {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Getter private BigInteger id_endereco;
    @Getter @Setter private BigInteger id_usuario;
    @Getter @Setter private String logradouro;
    @Getter @Setter private Integer numero;
    @Getter @Setter private String complemento;
    @Getter @Setter private String referencia;
    @Getter @Setter private String bairro;
    @Getter @Setter private String cep;
    @Getter @Setter private String cidade;
    @Getter @Setter private String estado;
    @Getter @Setter private String pais;
}
