package com.example.demo.Service.Implement;

import com.example.demo.Model.Produto;
import com.example.demo.Repository.ProdutoRepository;
import com.example.demo.Service.ProdutoService;
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
    public Produto findById(Long id) {
        return produtoRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Produto não encontrado."));
    }

    @Override
    public List<Produto> getAll() {
        return produtoRepository.findAll();
    }

    @Override
    public Produto save(Produto produto) {
        return produtoRepository.save(produto);
    }

    //implementar metodo de update
    @Override
    public Produto update(Long id, Produto produto) {
        return null;
    }

    @Override
    public void delete(Long id) {
        produtoRepository.deleteById(id);
    }
}
