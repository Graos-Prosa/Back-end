package com.example.demo.Service.Implement;

import com.example.demo.Model.Endereco;
import com.example.demo.Repository.EnderecoRepository;
import com.example.demo.Service.EnderecoService;
import org.springframework.stereotype.Service;

import java.math.BigInteger;
import java.util.List;

@Service
public class EnderecoServiceImpl implements EnderecoService {

    private final EnderecoRepository enderecoRepository;

    public EnderecoServiceImpl(EnderecoRepository enderecoRepository) {
        this.enderecoRepository = enderecoRepository;
    }

    @Override
    public Endereco getById(Long id) {
        return enderecoRepository.getById(id);
    }

    @Override
    public List<Endereco> getAll() {
        return enderecoRepository.findAll();
    }

    @Override
    public Endereco save(Endereco endereco) {
        return enderecoRepository.save(endereco);
    }

    //implementar metodo de update
    @Override
    public Endereco update(Long id, Endereco endereco) {
        return null;
    }

    @Override
    public void delete(Long id) {
        enderecoRepository.deleteById(id);
    }

    public Endereco buscarPorUsuario(Long id) {
        return enderecoRepository.findByUsuario_idUsuario(id).orElseThrow(() -> new RuntimeException("Endereço não encontrado"));
    }
}
