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
    @Column(name = "id_produto", nullable = false)
    @Getter private BigInteger idUsuario;
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
