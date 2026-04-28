package com.example.demo.DTO.Auth;

import com.example.demo.DTO.Credencial.CredencialDTO;
import io.swagger.v3.oas.annotations.media.Schema;

@Schema(description = "DTO de resposta do login")
public record LoginRespostaDTO(
        @Schema(description = "Indica se o login foi bem-sucedido", example = "true")
        boolean sucesso,
        @Schema(description = "Mensagem de retorno", example = "Login realizado com sucesso")
        String mensagem,
        @Schema(description = "Dados do usuário autenticado")
        CredencialDTO usuario,
        @Schema(
                description = "Token JWT gerado para autenticação",
                example = "eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9...",
                accessMode = Schema.AccessMode.READ_ONLY
        )
        String token
) {}