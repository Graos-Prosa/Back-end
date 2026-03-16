package com.example.demo.Service.Implement;

import com.example.demo.DTO.Auth.LoginRequestDTO;
import com.example.demo.DTO.Auth.LoginRespostaDTO;
import com.example.demo.DTO.Auth.RegistroRequestDTO;
import com.example.demo.DTO.Credencial.CredencialDTO;
import com.example.demo.Exception.AlreadyExistsExcpetion;
import com.example.demo.Model.Credencial;
import com.example.demo.Model.Usuario;
import com.example.demo.Repository.CredencialRepository;
import com.example.demo.Repository.UsuarioRepository;
import com.example.demo.Service.AuthService;
import com.example.demo.Service.TokenService;
import jakarta.transaction.Transactional;
import org.modelmapper.ModelMapper;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class AuthServiceImpl implements AuthService {

    private final CredencialRepository credencialRepository;
    private final UsuarioRepository usuarioRepository;
    //Esse autowired é porque essa classe é de config e tem o @bean, ou seja, ela é gerenciada pelo Spring
    //framework, e eu preciso dessa anotação para pedir ao spring que injete ele
    private TokenService tokenService;
    private PasswordEncoder passwordEncoder;
    ModelMapper modelMapper = new ModelMapper();

    public AuthServiceImpl(CredencialRepository credencialRepository, UsuarioRepository usuarioRepository) {
        this.credencialRepository = credencialRepository;
        this.usuarioRepository = usuarioRepository;
    }

    @Transactional
    @Override
    public LoginRespostaDTO registrar(RegistroRequestDTO registro) {

        //Transactional = Execute tudo dentro de uma transação. Se algo der erro, desfaz tudo
        //esse método isPresent verifica se valores optional retornam algum valor ou null
        if (credencialRepository.findByEmail(registro.email()).isPresent()) {
            throw new AlreadyExistsExcpetion("Email já cadastrado");
        }

        Usuario usuario = modelMapper.map(registro, Usuario.class);
        Credencial credencial = modelMapper.map(registro, Credencial.class);

        credencial.setUsuario(usuario);
        credencial.setSenha(passwordEncoder.encode(registro.senha()));

        usuarioRepository.save(usuario);
        Credencial credencialSalva = credencialRepository.save(credencial);

        String token = tokenService.gerarToken(credencialSalva);

        return new LoginRespostaDTO(true,
                "Login efetuado com sucesso!",
                new CredencialDTO(credencial),
                token);
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

        String token = tokenService.gerarToken(credencialExistente);

        return new LoginRespostaDTO(true,
                "Login efetuado com sucesso!",
                new CredencialDTO(credencialExistente),
                token);
    }
}
