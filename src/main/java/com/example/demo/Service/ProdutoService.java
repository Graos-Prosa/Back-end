package com.example.demo.Service;

import com.example.demo.DTO.ProdutoCreateDTO;
import com.example.demo.DTO.ProdutoDTO;
import com.example.demo.DTO.ProdutoUpdateDTO;
import com.example.demo.Model.Produto;

import java.math.BigInteger;
import java.util.List;

public interface ProdutoService {
    public ProdutoDTO findById(Long id);
    public List<ProdutoDTO> findAll();
    public ProdutoDTO save(ProdutoCreateDTO produto);
    public ProdutoDTO update(Long id, ProdutoUpdateDTO produto);
    public void delete(Long id);
}
