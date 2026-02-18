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
@ToString(exclude = "id_usuario")

public class Usuario {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Getter private BigInteger id_usuario;
    @Getter @Setter private String nome;
    @Getter @Setter private String sobrenome;
    @Getter @Setter private String telefone;
    @JsonFormat(pattern = "yyyy-MM-dd")
    @Getter @Setter private LocalDate aniversario;
    @Getter @Setter private LocalDateTime deletado_em;
}
