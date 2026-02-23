package com.example.demo.Model;

import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.persistence.*;
import lombok.*;

import java.math.BigInteger;
import java.time.LocalDate;
import java.time.LocalDateTime;

@Entity
@Table(name = "usuario")
@NoArgsConstructor
@AllArgsConstructor
@Getter @Setter
@ToString(exclude = "idUsuario")

public class Usuario {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_usuario", nullable = false)
    private BigInteger idUsuario;
    @OneToOne(mappedBy = "usuario", cascade = CascadeType.ALL, orphanRemoval = true)
    private Endereco endereco;
    @Column(name = "nome", nullable = false , length = 100)
    private String nome;
    @Column(name = "sobrenome", nullable = false , length = 100)
    private String sobrenome;
    @Column(name = "telefone", nullable = false , length = 20)
    private String telefone;
    @JsonFormat(pattern = "yyyy-MM-dd")
    @Column(name = "aniversario", nullable = true)
    private LocalDate aniversario;
    @Column(name = "deletado_em", nullable = true)
    private LocalDateTime deletado_em;
}
