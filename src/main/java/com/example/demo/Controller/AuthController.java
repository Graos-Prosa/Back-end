package com.example.demo.Controller;


import com.example.demo.DTO.Auth.LoginRequestDTO;
import com.example.demo.DTO.Auth.LoginRespostaDTO;
import com.example.demo.DTO.Auth.RegistroRequestDTO;
import com.example.demo.DTO.Credencial.CredencialCreateDTO;
import com.example.demo.DTO.Credencial.CredencialDTO;
import com.example.demo.DTO.Usuario.UsuarioDTO;
import com.example.demo.Model.Credencial;
import com.example.demo.Service.AuthService;
import com.example.demo.Service.CredencialService;
import jakarta.validation.Valid;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/autenticacao")
public class AuthController {

    private final AuthService authService;

    public AuthController(AuthService authService) {
        this.authService = authService;
    }

    //@Valid funciona para o controller validar as anotações colocadas nos DTOs
    @PostMapping("/registro")
    public LoginRespostaDTO registro(@RequestBody @Valid RegistroRequestDTO registroRequestDTO) {
        return authService.registrar(registroRequestDTO);
    }

    @PostMapping("/login")
    public LoginRespostaDTO login(@RequestBody @Valid LoginRequestDTO dto) {
        return authService.verificarAutenticidade(dto);
    }

    /* decidir se isso vai ficar assim
    @GetMapping("/eu")
    public UsuarioDTO eu(Authentication authentication) {
        Credencial credencial = (Credencial) authentication.getPrincipal();
        return new UsuarioDTO(credencial.getUsuario());
    }*/
}
