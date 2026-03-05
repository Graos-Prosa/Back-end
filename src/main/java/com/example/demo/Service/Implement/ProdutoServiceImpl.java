package com.example.demo.Service.Implement;

import com.example.demo.DTO.ProdutoCreateDTO;
import com.example.demo.DTO.ProdutoDTO;
import com.example.demo.Model.Produto;
import com.example.demo.Repository.ProdutoRepository;
import com.example.demo.Service.ProdutoService;
import org.springframework.stereotype.Service;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;

@Service
public class ProdutoServiceImpl implements ProdutoService {

    private final ProdutoRepository produtoRepository;

    public ProdutoServiceImpl(ProdutoRepository produtoRepository) {
        this.produtoRepository = produtoRepository;
    }

    @Override
    public ProdutoDTO findById(Long id) {
        Produto produto = produtoRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Produto não encontrado."));

        return new ProdutoDTO(produto);
    }

    @Override
    public List<ProdutoDTO> findAll() {
        List<Produto> produtos = produtoRepository.findAll();
        List<ProdutoDTO> produtoDTOS = new ArrayList<>();
        for (Produto produto : produtos) {
            produtoDTOS.add(new ProdutoDTO(produto));
        }

        return produtoDTOS;
    }

    @Override
    public ProdutoDTO save(ProdutoCreateDTO dto) {
        Produto produto = new Produto(dto);
        produtoRepository.save(produto);
        return new ProdutoDTO(produto);
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
