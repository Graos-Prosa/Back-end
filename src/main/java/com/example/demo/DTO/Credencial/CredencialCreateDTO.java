package com.example.demo.DTO.Credencial;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;

@Schema(description = "DTO para criação de credencial")
public record CredencialCreateDTO(
        @NotBlank(message = "Informe um email válido")
        @Email
        @Schema(description = "Email do usuário", example = "usuario@email.com")
        String email,
        @NotBlank(message = "Informe uma senha válida.")
        @Schema(description = "Senha do usuário", example = "Senha@123", accessMode = Schema.AccessMode.WRITE_ONLY)
        String senha
) {}
