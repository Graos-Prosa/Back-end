package com.example.demo.Service;

import com.example.demo.Model.Credencial;

public interface TokenService {
    public String gerarToken(Credencial credencial);
    public boolean validarToken(String token);
    public String extrairEmail(String token);
}
