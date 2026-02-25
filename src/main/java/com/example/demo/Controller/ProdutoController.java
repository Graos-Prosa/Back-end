package com.example.demo.Controller;

import com.example.demo.Model.Produto;
import com.example.demo.Service.ProdutoService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.swing.plaf.basic.BasicMenuItemUI;
import java.math.BigInteger;
import java.util.List;

@RestController
@RequestMapping("/produto")
public class ProdutoController {
    private final ProdutoService produtoService;

    public ProdutoController(ProdutoService produtoService) {
        this.produtoService = produtoService;
    }

    @GetMapping("/{id}")
    public Produto findById(@PathVariable Long id) {
        return produtoService.findById(id);
    }

    @GetMapping
    public List<Produto> getAll() {
        return produtoService.getAll();
    }

    @PostMapping
    public Produto create(@RequestBody Produto produto) {
        return produtoService.save(produto);
    }

    @PutMapping("/{id}")
    public Produto update( @PathVariable Long id, @RequestBody Produto produto) { return produtoService.update(id, produto);}

    @PatchMapping("/{id}")
    public Produto updatePartial(@PathVariable Long id, @RequestBody Produto produto) {
        return produtoService.updatePartial(id, produto);
    }

    //implementar autenticação de delete
    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        produtoService.delete(id);
    }

}
