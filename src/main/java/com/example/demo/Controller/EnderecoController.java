package com.example.demo.Controller;

import com.example.demo.Model.Endereco;
import com.example.demo.Service.EnderecoService;
import org.springframework.web.bind.annotation.*;

import java.math.BigInteger;
import java.util.List;

@RestController
@RequestMapping("/endereco")
public class EnderecoController {
    private final EnderecoService enderecoService;

    public EnderecoController(EnderecoService enderecoService) {
        this.enderecoService = enderecoService;
    }

    @GetMapping("/{id}")
    public Endereco getById(@PathVariable BigInteger id) {
        return enderecoService.getById(id);
    }

    @GetMapping
    public List<Endereco> getAll() {
        return enderecoService.getAll();
    }

    @PostMapping
    public Endereco create(@RequestBody Endereco endereco) {
        return enderecoService.save(endereco);
    }

    @PutMapping("/{id}")
    public Endereco update( @PathVariable BigInteger id, @RequestBody Endereco endereco) { return enderecoService.update(id, endereco);}

    //implementar autenticação de delete
    @DeleteMapping("/{id}")
    public void delete(@PathVariable BigInteger id) {
        enderecoService.delete(id);
    }

}
