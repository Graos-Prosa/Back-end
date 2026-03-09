package com.example.demo.Service;

import com.example.demo.DTO.Produto.ProdutoCreateDTO;
import com.example.demo.DTO.Produto.ProdutoDTO;
import com.example.demo.DTO.Produto.ProdutoUpdateDTO;

import java.util.List;

public interface ProdutoService {
    public ProdutoDTO findById(Long id);
    public List<ProdutoDTO> findAll();
    public ProdutoDTO save(ProdutoCreateDTO produto);
    public ProdutoDTO update(Long id, ProdutoUpdateDTO produto);
    public void delete(Long id);
}
