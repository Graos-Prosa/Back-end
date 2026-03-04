package com.example.demo.Service;

import com.example.demo.DTO.EnderecoDTO;
import com.example.demo.Model.Credencial;
import com.example.demo.Model.Endereco;

import java.math.BigInteger;
import java.util.List;

public interface EnderecoService {
    public EnderecoDTO findById(Long id);
    public List<EnderecoDTO> findAll();
    public EnderecoDTO save(Endereco endereco);
    public EnderecoDTO update(Long id, Endereco endereco);
    public EnderecoDTO updatePartial(Long id, Endereco endereco);
    public void delete(Long id);
    public Endereco buscarPorUsuario(Long id);
}
