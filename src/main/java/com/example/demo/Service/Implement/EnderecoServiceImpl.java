package com.example.demo.Service.Implement;

import com.example.demo.DTO.EnderecoDTO;
import com.example.demo.DTO.EnderecoUpdateDTO;
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

    @Override
    public EnderecoDTO update(Long id, EnderecoUpdateDTO novo) {
        Endereco existente = enderecoRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Endereço não encontrado."));

        if (novo.logradouro() != null) {
            existente.setLogradouro(novo.logradouro());
        }

        if (novo.numero() != null) {
            existente.setNumero(novo.numero());
        }

        if (novo.complemento() != null) {
            existente.setComplemento(novo.complemento());
        }

        if (novo.bairro() != null) {
            existente.setBairro(novo.bairro());
        }

        if (novo.cidade() != null) {
            existente.setCidade(novo.cidade());
        }

        if (novo.estado() != null) {
            existente.setEstado(novo.estado());
        }

        if (novo.cep() != null) {
            existente.setCep(novo.cep());
        }

        if (novo.referencia() != null) {
            existente.setReferencia(novo.referencia());
        }

        if (novo.pais() != null) {
            existente.setPais(novo.pais());
        }

        return new EnderecoDTO(enderecoRepository.save(existente));
    }

    @Override
    public void delete(Long id) {
        enderecoRepository.deleteById(id);
    }

    public Endereco buscarPorUsuario(Long id) {
        return enderecoRepository.findByUsuario_idUsuario(id).orElseThrow(() -> new RuntimeException("Endereço não encontrado"));
    }
}
