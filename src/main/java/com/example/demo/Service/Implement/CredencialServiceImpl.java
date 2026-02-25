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

    @Override
    public Credencial getById(Long id) {
        return credencialRepository.getById(id);
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
    public void delete(Long id) {
        credencialRepository.deleteById(id);
    }
}
