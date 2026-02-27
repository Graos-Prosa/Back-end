package com.example.demo.Service.Implement;

import com.example.demo.Model.Pedido;
import com.example.demo.Repository.PedidoRepository;
import com.example.demo.Service.PedidoService;
import org.springframework.stereotype.Service;

import java.math.BigInteger;
import java.util.List;

@Service
public class PedidoServiceImpl implements PedidoService {

    private final PedidoRepository pedidoRepository;

    public PedidoServiceImpl(PedidoRepository pedidoRepository) {
        this.pedidoRepository = pedidoRepository;
    }

    @Override
    public Pedido findById(Long id) {
        return pedidoRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Pedido não encontrado."));
    }

    @Override
    public List<Pedido> findAll() {
        return pedidoRepository.findAll();
    }

    @Override
    public Pedido save(Pedido pedido) {
        return pedidoRepository.save(pedido);
    }

    //implementar metodo de update
    @Override
    public Pedido update(Long id, Pedido pedido) {
        return null;
    }

    @Override
    public Pedido updatePartial(Long id, Pedido novo) {
        Pedido existente = pedidoRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Pedido não encontrado."));

        if (novo.getEstado() != null) {
            existente.setEstado(novo.getEstado());
        }

        if (novo.getDesconto() != null) {
            existente.setDesconto(novo.getDesconto());
        }

        if (novo.getValorTotal() != null) {
            existente.setValorTotal(novo.getValorTotal());
        }

        if (novo.getValorFinal() != null) {
            existente.setValorFinal(novo.getValorFinal());
        }

        return pedidoRepository.save(existente);
    }

    @Override
    public void delete(Long id) {
        pedidoRepository.deleteById(id);
    }
}
