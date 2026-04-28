package com.example.demo.DTO.Usuario;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotBlank;

import java.time.LocalDate;

@Schema(description = "DTO para criação de usuário")
public record UsuarioCreateDTO(
        @NotBlank(message = "O nome precisa ser válido.")
        @Schema(description = "Nome do usuário", example = "João")
        String nome,
        @NotBlank(message = "Sobrenome precisa ser válido.")
        @Schema(description = "Sobrenome do usuário", example = "Silva")
        String sobrenome,
        @Schema(description = "Telefone do usuário", example = "11999999999")
        String telefone,
        @Schema(description = "Data de aniversário", example = "01-01-2000")
        LocalDate aniversario
) {}