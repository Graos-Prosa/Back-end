package com.example.demo.DTO.Auth;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;

@Schema(description = "DTO para autenticação de login de usuário")
public record LoginRequestDTO(
        @NotBlank(message = "Email é obrigatório.")
        @Email(message = "Informe um email válido.")
        @Schema(description = "Email do usuário", example = "usuario@email.com")
        String email,

        @NotBlank(message = "Senha é obrigatória.")
        @Schema(
                description = "Senha do usuário",
                example = "Senha@123",
                accessMode = Schema.AccessMode.WRITE_ONLY
        )
        String senha
) {}
