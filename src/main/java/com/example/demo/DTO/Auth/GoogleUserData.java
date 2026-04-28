package com.example.demo.DTO.Auth;

import io.swagger.v3.oas.annotations.media.Schema;

@Schema(description = "Dados do usuário retornados pelo Google")
public record GoogleUserData(
        @Schema(description = "Email do usuário", example = "usuario@gmail.com")
        String email,
        @Schema(description = "Nome do usuário", example = "João")
        String nome,
        @Schema(description = "Sobrenome do usuário", example = "Silva")
        String sobrenome
) {}