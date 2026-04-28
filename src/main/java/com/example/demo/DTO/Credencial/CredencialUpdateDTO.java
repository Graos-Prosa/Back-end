package com.example.demo.DTO.Credencial;

import io.swagger.v3.oas.annotations.media.Schema;

@Schema(description = "DTO para atualização de credencial")
public record CredencialUpdateDTO(
        @Schema(description = "Novo email do usuário", example = "novo@email.com")
        String email,
        @Schema(description = "Nova senha do usuário", example = "NovaSenha@123", accessMode = Schema.AccessMode.WRITE_ONLY)
        String senha
) {}