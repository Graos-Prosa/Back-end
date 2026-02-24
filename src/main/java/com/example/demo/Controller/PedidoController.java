package com.example.demo.Controller;

import com.example.demo.Model.Pedido;
import com.example.demo.Service.PedidoService;
import org.springframework.web.bind.annotation.*;

import java.math.BigInteger;
import java.util.List;

@RestController
@RequestMapping("/pedido")
public class PedidoController {
    private final PedidoService pedidoService;

    public PedidoController(PedidoService pedidoService) {
        this.pedidoService = pedidoService;
    }

    @GetMapping("/{id}")
    public Pedido getById(@PathVariable BigInteger id) {
        return pedidoService.getById(id);
    }

    @GetMapping
    public List<Pedido> getAll() {
        return pedidoService.getAll();
    }

    @PostMapping
    public Pedido create(@RequestBody Pedido pedido) {
        return pedidoService.save(pedido);
    }

    @PutMapping("/{id}")
    public Pedido update( @PathVariable BigInteger id, @RequestBody Pedido pedido) { return pedidoService.update(id, pedido);}

    //implementar autenticação de delete
    @DeleteMapping("/{id}")
    public void delete(@PathVariable BigInteger id) {
        pedidoService.delete(id);
    }

}
