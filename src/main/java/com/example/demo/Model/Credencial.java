package com.example.demo.Model;

import jakarta.persistence.*;
import lombok.*;

import java.math.BigInteger;
import java.time.LocalDateTime;

@Entity
@Table(name = "credencial")
@NoArgsConstructor
@AllArgsConstructor
@ToString(exclude = "id_credencial")

public class Credencial {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Getter private BigInteger id_credencial;
    @Getter @Setter private BigInteger id_usuario;
    @Getter @Setter private String email;
    @Getter @Setter private String senha;
    @Getter @Setter private LocalDateTime criado_em;
}
