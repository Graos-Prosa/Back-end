package com.example.demo.Service;

import com.example.demo.Model.Produto;

import java.math.BigInteger;
import java.util.List;

public interface ProdutoService {
    public Produto findById(Long id);
    public List<Produto> getAll();
    public Produto save(Produto produto);
    public Produto update(Long id, Produto produto);
    public void delete(Long id);
}
