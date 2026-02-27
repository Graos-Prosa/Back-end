package com.example.demo.Service.Implement;

import com.example.demo.Model.Credencial;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.springframework.stereotype.Service;

import java.util.Date;

@Service
public class JwtService {

    // Em produção, coloque essa chave em variável de ambiente
    private final String SECRET_KEY = "MinhaChaveSuperSecretaMuitoForte";

    // Token válido por 1 hora
    private final long EXPIRATION_TIME = 1000 * 60 * 60;

    // Gera JWT a partir da credencial
    public String gerarToken(Credencial credencial) {
        return Jwts.builder()
                .setSubject(credencial.getEmail()) // identifica o usuário
                .claim("usuario", credencial.getUsuario().getNome()) // nome do usuário
                .setIssuedAt(new Date())
                .setExpiration(new Date(System.currentTimeMillis() + EXPIRATION_TIME))
                .signWith(SignatureAlgorithm.HS256, SECRET_KEY)
                .compact();
    }

    // Valida token
    public boolean validarToken(String token) {
        try {
            Jwts.parser()
                    .setSigningKey(SECRET_KEY)
                    .parseClaimsJws(token);
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    // Extrai email do token
    public String extrairEmail(String token) {
        return Jwts.parser()
                .setSigningKey(SECRET_KEY)
                .parseClaimsJws(token)
                .getBody()
                .getSubject();
    }
}