package com.example.demo.Controller;

import com.example.demo.Model.Credencial;
import com.example.demo.Service.CredencialService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/credencial")
public class CredencialController {

    // @RequestBody converte o JSON enviado na requisição em um objeto Java
    // @PathVariable pega o valor que vem na URL (ex: /credenciais/5 → id = 5)

    private final CredencialService credencialService;

    public CredencialController(CredencialService credencialService) {
        this.credencialService = credencialService;
    }

    @GetMapping("/{id}")
    public Credencial findById(@PathVariable Long id) {
        return credencialService.findById(id);
    }

    @GetMapping
    public List<Credencial> findAll() {
        return credencialService.findAll();
    }

    @PostMapping
    public Credencial create(@RequestBody Credencial credencial) {
        return credencialService.save(credencial);
    }

    @PutMapping("/{id}")
    public Credencial update(@PathVariable Long id, @RequestBody Credencial credencial) { return credencialService.update(id, credencial);}

    @PatchMapping("/{id}")
    public Credencial updateSenha(@PathVariable Long id, @RequestBody Credencial credencial) {
        return credencialService.updateSenha(id, credencial);
    }

    //implementar autenticação de delete
    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        credencialService.delete(id);
    }

}

