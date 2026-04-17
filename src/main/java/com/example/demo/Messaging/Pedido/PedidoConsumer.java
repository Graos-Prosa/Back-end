package com.example.demo.Messaging.Pedido;

import com.example.demo.DTO.Pedido.PedidoDTO;
import com.example.demo.Service.PagamentoService;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

@Component
public class PedidoConsumer {
    private final PagamentoService pagamentoService;

    public PedidoConsumer (PagamentoService pagamentoService) {
        this.pagamentoService = pagamentoService;
    }

    @RabbitListener(queues = "pedido.fila")
    public void consumirPedido(PedidoDTO pedido) {
        System.out.println("Pedido recebido - " + pedido.toString());
        pagamentoService.save(pedido);
    }
}
