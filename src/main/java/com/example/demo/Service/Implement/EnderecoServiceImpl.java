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
    public Endereco findById(Long id) {
        return enderecoRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Endereço não encontrado."));
    }

    @Override
    public List<Endereco> findAll() {
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
    public Endereco updatePartial(Long id, Endereco novo) {
        Endereco existente = enderecoRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Endereço não encontrado."));

        if (novo.getLogradouro() != null) {
            existente.setLogradouro(novo.getLogradouro());
        }

        if (novo.getNumero() != null) {
            existente.setNumero(novo.getNumero());
        }

        if (novo.getComplemento() != null) {
            existente.setComplemento(novo.getComplemento());
        }

        if (novo.getBairro() != null) {
            existente.setBairro(novo.getBairro());
        }

        if (novo.getCidade() != null) {
            existente.setCidade(novo.getCidade());
        }

        if (novo.getEstado() != null) {
            existente.setEstado(novo.getEstado());
        }

        if (novo.getCep() != null) {
            existente.setCep(novo.getCep());
        }

        if (novo.getReferencia() != null) {
            existente.setReferencia(novo.getReferencia());
        }

        if (novo.getPais() != null) {
            existente.setPais(novo.getPais());
        }

        return enderecoRepository.save(existente);
    }

    @Override
    public void delete(Long id) {
        enderecoRepository.deleteById(id);
    }

    public Endereco buscarPorUsuario(Long id) {
        return enderecoRepository.findByUsuario_idUsuario(id).orElseThrow(() -> new RuntimeException("Endereço não encontrado"));
    }
}
