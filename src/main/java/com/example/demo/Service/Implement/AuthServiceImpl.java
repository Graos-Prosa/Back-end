package com.example.demo.Service.Implement;

import com.example.demo.DTO.Auth.LoginRequestDTO;
import com.example.demo.DTO.Auth.LoginRespostaDTO;
import com.example.demo.DTO.Credencial.CredencialCreateDTO;
import com.example.demo.DTO.Credencial.CredencialDTO;
import com.example.demo.Model.Credencial;
import com.example.demo.Repository.CredencialRepository;
import com.example.demo.Service.AuthService;
import com.example.demo.Service.EnderecoService;
import com.example.demo.Service.JwtService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;

import java.util.Optional;

public class AuthServiceImpl implements AuthService {

    private final CredencialRepository credencialRepository;
    private JwtService jwtService;
    //Esse autowired é porque essa classe é de config e tem o @bean, ou seja, ela é gerenciada pelo Spring
    //framework, e eu preciso dessa anotação para pedir ao spring que injete ele
    private PasswordEncoder passwordEncoder;

    public AuthServiceImpl(CredencialRepository credencialRepository) {
        this.credencialRepository = credencialRepository;
    }


    @Override
    public LoginRespostaDTO verificarAutenticidade(LoginRequestDTO login) {

        Optional<Credencial> existente = credencialRepository.findByEmail(login.email());

        if (existente.isEmpty()) {
            return new LoginRespostaDTO(false, "Usuário não encontrado.", null, null);
        }

        //esse .get() pega o objeto credencial dentro do optional
        Credencial credencialExistente = existente.get();

        //esse matches compara a senha hash salva no banco com o hash da senha digitada
        if (!passwordEncoder.matches(login.senha(), credencialExistente.getSenha())) {
            return new LoginRespostaDTO(false, "Senha inválida", null, null);
        }

        String token = jwtService.gerarToken(credencialExistente);

        return new LoginRespostaDTO(true,
                "Login efetuado com sucesso!",
                new CredencialDTO(credencialExistente),
                token);
    }
}
