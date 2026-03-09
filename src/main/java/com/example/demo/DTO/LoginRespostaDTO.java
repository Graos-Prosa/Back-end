package com.example.demo.DTO;

import com.example.demo.DTO.Credencial.CredencialDTO;

public record LoginRespostaDTO(
        boolean sucesso,
        String mensagem,
        CredencialDTO usuario,
        String token
) {}