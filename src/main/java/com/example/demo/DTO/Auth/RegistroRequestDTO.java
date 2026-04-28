package com.example.demo.DTO.Auth;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;

import java.time.LocalDate;

@Schema(description = "DTO para registro de novo usuário")
public record RegistroRequestDTO(
        @NotBlank(message = "Informe um email válido")
        @Email
        @Schema(description = "Email do usuário", example = "usuario@email.com")
        String email,
        @NotBlank(message = "Informe uma senha válida.")
        @Schema(
                description = "Senha do usuário",
                example = "Senha@123",
                accessMode = Schema.AccessMode.WRITE_ONLY
        )
        String senha,
        @NotBlank(message = "O nome precisa ser válido.")
        @Schema(description = "Nome do usuário", example = "João")
        String nome,
        @NotBlank(message = "Sobrenome precisa ser válido.")
        @Schema(description = "Sobrenome do usuário", example = "Silva")
        String sobrenome,
        @NotBlank(message = "Telefone precisa ser válido.")
        @Schema(description = "Telefone do usuário", example = "11999999999")
        String telefone,
        @Schema(description = "Data de aniversário", example = "01-01-2000")
        LocalDate aniversario
) {}