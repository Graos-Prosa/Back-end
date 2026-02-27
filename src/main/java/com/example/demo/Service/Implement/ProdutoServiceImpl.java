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
    public List<Produto> findAll() {
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
    public Produto updatePartial(Long id, Produto novo) {
        Produto existente = produtoRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Produto não encontrado!"));

        if (novo.getTitulo() != null) {
            existente.setTitulo(novo.getTitulo());
        }

        if (novo.getDescricao() != null) {
            existente.setDescricao(novo.getDescricao());
        }

        if (novo.getQuantidade() != null) {
            existente.setQuantidade(novo.getQuantidade());
        }

        if (novo.getImagemUrl() != null) {
            existente.setImagemUrl(novo.getImagemUrl());
        }

        if (novo.getTipo() != null) {
            existente.setTipo(novo.getTipo());
        }

        if (novo.getPreco() != null) {
            existente.setPreco(novo.getPreco());
        }

        return produtoRepository.save(existente);
    }

    @Override
    public void delete(Long id) {
        produtoRepository.deleteById(id);
    }
}
