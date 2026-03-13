package com.example.demo.DTO.Auth;

import com.example.demo.DTO.Credencial.CredencialDTO;

public record LoginRespostaDTO(
        boolean sucesso,
        String mensagem,
        CredencialDTO usuario,
        String token
) {}