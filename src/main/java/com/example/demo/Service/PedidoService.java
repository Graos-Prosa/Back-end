package com.example.demo.Service;

import com.example.demo.Model.Pedido;

import java.math.BigInteger;
import java.util.List;

public interface PedidoService {
    public Pedido getById(BigInteger id);
    public List<Pedido> getAll();
    public Pedido save(Pedido pedido);
    public Pedido update(BigInteger id, Pedido pedido);
    public void delete(BigInteger id);
}
