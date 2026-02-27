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
    public Pedido findById(@PathVariable Long id) {
        return pedidoService.findById(id);
    }

    @GetMapping
    public List<Pedido> findAll() {
        return pedidoService.findAll();
    }

    @PostMapping
    public Pedido create(@RequestBody Pedido pedido) {
        return pedidoService.save(pedido);
    }

    @PutMapping("/{id}")
    public Pedido update( @PathVariable Long id, @RequestBody Pedido pedido) { return pedidoService.update(id, pedido);}

    @PatchMapping("/{id}")
    public Pedido updatePartial(@PathVariable Long id, @RequestBody Pedido pedido) {
        return pedidoService.updatePartial(id, pedido);
    }

    //implementar autenticação de delete
    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        pedidoService.delete(id);
    }

}
