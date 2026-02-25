package com.example.demo.Model;

import jakarta.persistence.*;
import lombok.*;

import java.math.BigInteger;
import java.time.LocalDateTime;

@Entity
@Table(name = "credencial")
@NoArgsConstructor
@AllArgsConstructor
@Getter @Setter
@ToString(exclude = "idCredencial")

// como eu usei findById, preciso rever nas entidades o conceito de:
// @OneToOne(fetch = FetchType.LAZY) ou FetchType.EAGER

public class Credencial {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_credencial", nullable = false)
    private Long idCredencial;
    @OneToOne
    @JoinColumn(name = "id_usuario")
    private Usuario usuario;
    @Column(name = "email", nullable = false, length = 80)
    private String email;
    @Column(name = "senha", nullable = false, length = 100)
    private String senha;
    @Column(name = "criado_em", nullable = false)
    private LocalDateTime criado_em;
}
