package com.example.demo.Service;

import com.example.demo.Model.Produto;

import java.math.BigInteger;
import java.util.List;

public interface ProdutoService {
    public Produto getById(BigInteger id);
    public List<Produto> getAll();
    public Produto save(Produto produto);
    public Produto update(BigInteger id, Produto produto);
    public Void delete(BigInteger id);
}
