package com.example.demo.Service.Implement;

import com.example.demo.Model.Credencial;
import com.example.demo.DTO.Auth.GoogleUserData;
import com.example.demo.Model.Usuario;
import com.example.demo.Service.GoogleService;
import org.modelmapper.ModelMapper;

public class GoogleServiceImpl implements GoogleService {

    ModelMapper modelMapper = new ModelMapper();

    @Override
    public GoogleUserData validarToken(String token) {

    }

    @Override
    public Credencial criarUsuarioGoogle(GoogleUserData data) {
        Usuario usuario = modelMapper.map(data, Usuario.class);
        Credencial credencial = new Credencial();
        credencial.setUsuario(usuario);

    }
}
