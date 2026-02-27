package com.example.demo.Service.Implement;

import com.example.demo.Model.Credencial;
import com.example.demo.Repository.CredencialRepository;
import com.example.demo.Service.CredencialService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.math.BigInteger;
import java.util.List;
import java.util.Optional;

@Service
public class CredencialServiceImpl implements CredencialService {

    private final CredencialRepository credencialRepository;

    //Esse autowired é porque essa classe é de config e tem o @bean, ou seja, ela é gerenciada pelo Spring
    //framework, e eu preciso dessa anotação para pedir ao spring que injete ele
    @Autowired
    private PasswordEncoder passwordEncoder;

    private JwtService jwtService;

    public CredencialServiceImpl(CredencialRepository credencialRepository) {
        this.credencialRepository = credencialRepository;
    }

    //Esses @Override em cima dos métodos é pra dizer olha, estou usando esse método que está na interface

    // Uso findById porque getById pode retornar um proxy (objeto temporário
    // que só carrega dados ao acessar seus atributos). findById é mais seguro.

    @Override
    public Credencial findById(Long id) {
        return credencialRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Credencial não encontrada."));
        //.orElseThrow() faz com que o método retorno um objeto invés de um Optional
    }

    @Override
    public List<Credencial> getAll() {
        return credencialRepository.findAll();
    }

    @Override
    public Credencial save(Credencial credencial) {
        String senhaCriptografada = passwordEncoder.encode(credencial.getSenha());
        credencial.setSenha(senhaCriptografada);
        return credencialRepository.save(credencial);
    }

    //implementar metodo de update
    @Override
    public Credencial update(Long id, Credencial credencial) {
        return null;
    }

    @Override
    public Credencial updateSenha(Long id, Credencial nova) {
        Credencial existente = credencialRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Credencial não encontrada."));

        if (nova.getSenha() != null) {
            existente.setSenha(nova.getSenha());
        }

        //melhor retornar o objeto ou null?
        return credencialRepository.save(existente);
    }

    @Override
    public void delete(Long id) {
        credencialRepository.deleteById(id);
    }

    @Override
    public LoginRespostaDTO verificarAutenticidade(Credencial credencial) {

        Optional<Credencial> existente = credencialRepository.findByEmail(credencial.getEmail());

        if (existente.isEmpty()) {
            return new LoginRespostaDTO(false, "Usuário não encontrado.", null, null);
        }

        //esse .get() pega o objeto credencial dentro do optional
        Credencial credencialExistente = existente.get();
        String senhaDigitada = credencial.getSenha();

        if (!passwordEncoder.matches(credencial.getSenha(), credencialExistente.getSenha())) {
            return new LoginResponseDTO(false, "Senha inválida", null, null);
        }

        String token = jwtService.gerarToken(credencialExistente);

        return new LoginRespostaDTO(true,
                "Login efetuado com sucesso!",
                new CredencialDTO(credencialExistente),
                token);
    }
}
