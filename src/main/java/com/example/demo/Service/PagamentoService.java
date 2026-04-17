package com.example.demo.Service;

import com.example.demo.DTO.Pagamento.PagamentoDTO;
import com.example.demo.DTO.Pagamento.PagamentoUpdateDTO;
import com.example.demo.Model.Pedido;

import java.util.List;

public interface PagamentoService {
    public PagamentoDTO findById(Long id);
    public List<PagamentoDTO> findAll();
    public PagamentoDTO save(Pedido pedido);
    public PagamentoDTO update(Long id, PagamentoUpdateDTO pagamento);
    public void delete(Long id);
}
