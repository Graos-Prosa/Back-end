package com.example.demo.Controller;


import com.example.demo.DTO.Auth.LoginRequestDTO;
import com.example.demo.DTO.Auth.LoginRespostaDTO;
import com.example.demo.DTO.Credencial.CredencialCreateDTO;
import com.example.demo.DTO.Credencial.CredencialDTO;
import com.example.demo.Service.AuthService;
import com.example.demo.Service.CredencialService;
import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/autenticacao")
public class AuthController {

    private final AuthService authService;

    public AuthController(AuthService authService) {
        this.authService = authService;
    }

    //@Valid funciona para o controller validar as anotações colocadas nos DTOs
    @PostMapping
    public CredencialDTO create(@RequestBody @Valid CredencialCreateDTO credencial) {
        return authService.save(credencial);
    }

    @PostMapping("/login")
    public LoginRespostaDTO login(@RequestBody @Valid LoginRequestDTO dto) {
        return authService.verificarAutenticidade(dto);
    }
}
