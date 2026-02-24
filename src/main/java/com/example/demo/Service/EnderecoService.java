package com.example.demo.Service;

import com.example.demo.Model.Endereco;

import java.math.BigInteger;
import java.util.List;

public interface EnderecoService {
    public Endereco getById(BigInteger id);
    public List<Endereco> getAll();
    public Endereco save(Endereco endereco);
    public Endereco update(BigInteger id, Endereco endereco);
    public void delete(BigInteger id);
}
