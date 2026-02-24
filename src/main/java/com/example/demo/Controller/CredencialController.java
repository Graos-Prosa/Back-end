package com.example.demo.Controller;

import com.example.demo.Model.Credencial;
import com.example.demo.Service.CredencialService;
import org.springframework.web.bind.annotation.*;

import java.math.BigInteger;
import java.util.List;

@RestController
@RequestMapping("/credencial")
public class CredencialController {
    private final CredencialService credencialService;

    public CredencialController(CredencialService credencialService) {
        this.credencialService = credencialService;
    }

    @GetMapping("/{id}")
    public Credencial getById(@PathVariable BigInteger id) {
        return credencialService.getById(id);
    }

    @GetMapping
    public List<Credencial> getAll() {
        return credencialService.getAll();
    }

    @PostMapping
    public Credencial create(@RequestBody Credencial credencial) {
        return credencialService.save(credencial);
    }

    @PutMapping("/{id}")
    public Credencial update( @PathVariable BigInteger id, @RequestBody Credencial credencial) { return credencialService.update(id, credencial);}

    //implementar autenticação de delete
    @DeleteMapping("/{id}")
    public void delete(@PathVariable BigInteger id) {
        credencialService.delete(id);
    }

}
