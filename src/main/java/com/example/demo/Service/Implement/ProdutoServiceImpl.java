package com.example.demo.Service.Implement;

import com.example.demo.Model.Produto;
import com.example.demo.Repository.ProdutoRepository;
import com.example.demo.Service.ProdutoService;
import com.example.demo.Service.UsuarioService;
import org.springframework.stereotype.Service;

import java.math.BigInteger;
import java.util.List;

@Service
public class ProdutoServiceImpl implements ProdutoService {
    private final ProdutoRepository produtoRepository;

    public ProdutoServiceImpl(ProdutoRepository produtoRepository) {
        this.produtoRepository = produtoRepository;
    }

    @Override
    public Produto getById(BigInteger id) {
        return null;
    }

    @Override
    public List<Produto> getAll() {
        return List.of();
    }

    @Override
    public Produto save(Produto produto) {
        return null;
    }

    @Override
    public Produto update(BigInteger id, Produto produto) {
        return null;
    }

    @Override
    public Void delete(BigInteger id) {
        return null;
    }
}
