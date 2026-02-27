package com.example.demo.DTO;

public record LoginRespostaDTO(
        boolean sucesso,
        String mensagem,
        CredencialDTO usuario,
        String token
) {}