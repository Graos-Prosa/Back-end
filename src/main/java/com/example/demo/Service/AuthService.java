package com.example.demo.Service;

import com.example.demo.DTO.Auth.LoginRequestDTO;
import com.example.demo.DTO.Auth.LoginRespostaDTO;
import com.example.demo.DTO.Credencial.CredencialCreateDTO;
import com.example.demo.DTO.Credencial.CredencialDTO;

public interface AuthService {

    public LoginRespostaDTO verificarAutenticidade(LoginRequestDTO login);
    //public LoginRespostaDTO registrar(RegistroRequestDTO registro);
}
