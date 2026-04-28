package com.example.demo.DTO.Usuario;

import io.swagger.v3.oas.annotations.media.Schema;

import java.time.LocalDate;

@Schema(description = "DTO para atualização de usuário")
public record UsuarioUpdateDTO(
        @Schema(description = "Nome do usuário", example = "João")
        String nome,
        @Schema(description = "Sobrenome do usuário", example = "Silva")
        String sobrenome,
        @Schema(description = "Telefone do usuário", example = "11999999999")
        String telefone,
        @Schema(description = "Data de aniversário", example = "01-01-2000")
        LocalDate aniversario
) {}