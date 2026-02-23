package com.example.demo.Service;

import com.example.demo.Model.Endereco;
import com.example.demo.Repository.EnderecoRepository;
import org.springframework.stereotype.Service;

import java.math.BigInteger;
import java.util.Optional;

@Service
public class EnderecoService {

    private final EnderecoRepository enderecoRepository;

    public EnderecoService(EnderecoRepository enderecoRepository) {
        this.enderecoRepository = enderecoRepository;
    }

    public Endereco save(Endereco endereco) {
        return enderecoRepository.save(endereco);
    }

    public Endereco buscarPorUsuario(BigInteger id) {
        return enderecoRepository.findByIdUsuario(id).orElseThrow(() -> new RuntimeException("Endereço não encontrado"));
    }

    public void delete(BigInteger id) {
        enderecoRepository.deleteById(id);
    }
}
