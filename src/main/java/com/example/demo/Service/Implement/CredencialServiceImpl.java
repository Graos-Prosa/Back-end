package com.example.demo.Service.Implement;

import com.example.demo.Model.Credencial;
import com.example.demo.Repository.CredencialRepository;
import com.example.demo.Service.CredencialService;
import org.springframework.stereotype.Service;

import java.math.BigInteger;
import java.util.List;

@Service
public class CredencialServiceImpl implements CredencialService {

    private final CredencialRepository credencialRepository;

    public CredencialServiceImpl(CredencialRepository credencialRepository) {
        this.credencialRepository = credencialRepository;
    }

    //Esses @Override em cima dos métodos é pra dizer olha, estou usando esse método que está na interface

    @Override
    public Credencial FindById(Long id) {
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
        return credencialRepository.save(credencial);
    }

    //implementar metodo de update
    @Override
    public Credencial update(Long id, Credencial credencial) {
        return null;
    }

    @Override
    public Credencial updatePartial(Long id, Credencial credencial) {
        Credencial existente = credencial;
    }

    @Override
    public void delete(Long id) {
        credencialRepository.deleteById(id);
    }
}
