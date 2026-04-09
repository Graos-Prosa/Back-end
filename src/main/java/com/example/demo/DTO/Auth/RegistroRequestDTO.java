package com.example.demo.DTO.Auth;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;

import java.time.LocalDate;

public record RegistroRequestDTO (
        @NotBlank(message = "Informe um email válido") @Email
        String email,
        @NotBlank(message = "Informe um email válido.")
        String senha,
        @NotBlank(message = "O nome precisa ser válido.")
        String nome,
        @NotBlank(message = "Sobrenome precisa ser válido.")
        String sobrenome,
        @NotBlank(message = "Telefone precisa ser válido.")
        String telefone,
        LocalDate aniversario
) {}
