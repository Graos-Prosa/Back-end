package com.example.demo.Service;

import com.example.demo.Model.Credencial;
import com.example.demo.Model.Endereco;

import java.math.BigInteger;
import java.util.List;

public interface EnderecoService {
    public Endereco findById(Long id);
    public List<Endereco> getAll();
    public Endereco save(Endereco endereco);
    public Endereco update(Long id, Endereco endereco);
    public Endereco updatePartial(Long id, Endereco endereco);
    public void delete(Long id);
}
