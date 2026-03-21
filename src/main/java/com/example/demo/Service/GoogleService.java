package com.example.demo.Service;

import com.example.demo.Model.Credencial;
import com.example.demo.DTO.Auth.GoogleUserData;
import com.example.demo.Model.Usuario;

public interface GoogleService {
    public GoogleUserData validarToken(String token);
    public Credencial criarUsuarioGoogle(GoogleUserData data);
}
