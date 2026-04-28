package com.example.demo.DTO.Auth;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;

@Schema(description = "DTO para login com Google")
public record LoginGoogleDTO(
        @Schema(
                description = "Token JWT fornecido pelo Google",
                example = "eyJhbGciOiJSUzI1NiIsImtpZCI6Ij..."
        )
        String token
) {}