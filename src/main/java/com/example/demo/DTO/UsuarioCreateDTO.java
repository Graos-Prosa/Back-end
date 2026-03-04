package com.example.demo.DTO;

import java.time.LocalDate;

public record UsuarioCreateDTO(
        String nome,
        String sobrenome,
        String telefone,
        LocalDate aniversario
) {}