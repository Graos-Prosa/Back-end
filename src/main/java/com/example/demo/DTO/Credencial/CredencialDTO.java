package com.example.demo.DTO.Credencial;

import com.example.demo.Model.Credencial;
import com.example.demo.Model.Role;
import io.swagger.v3.oas.annotations.media.Schema;

import java.util.List;

@Schema(description = "DTO de retorno da credencial")
public record CredencialDTO(
        @Schema(description = "ID da credencial", example = "1")
        Long id,
        @Schema(description = "Email do usuário", example = "usuario@email.com")
        String email,
        @Schema(description = "Nome do usuário", example = "João")
        String nome,
        @Schema(description = "Sobrenome do usuário", example = "Silva")
        String sobrenome,
        @Schema(description = "Lista de roles/perfis do usuário")
        List<Role> roles
) {
    public CredencialDTO(Credencial credencial) {
        this(
                credencial.getIdCredencial(),
                credencial.getEmail(),
                credencial.getUsuario() != null ? credencial.getUsuario().getNome() : null,
                credencial.getUsuario() != null ? credencial.getUsuario().getSobrenome() : null,
                credencial.getRoles()
        );
    }
}