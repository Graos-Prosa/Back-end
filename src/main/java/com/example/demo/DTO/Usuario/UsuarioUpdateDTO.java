package com.example.demo.DTO.Usuario;

import java.time.LocalDate;

public record UsuarioUpdateDTO(
        String nome,
        String sobrenome,
        String telefone,
        LocalDate aniversario
) {}