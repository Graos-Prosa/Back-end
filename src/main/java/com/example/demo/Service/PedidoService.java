package com.example.demo.Service;

import com.example.demo.Model.Item;
import com.example.demo.Model.Pedido;

import java.math.BigInteger;
import java.util.List;

public interface PedidoService {
    public Pedido findById(Long id);
    public List<Pedido> getAll();
    public Pedido save(Pedido pedido);
    public Pedido update(Long id, Pedido pedido);
    public Pedido updatePartial(Long id, Pedido pedido);
    public void delete(Long id);
}
