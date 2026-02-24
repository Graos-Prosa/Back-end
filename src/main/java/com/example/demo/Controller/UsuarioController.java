package com.example.demo.Controller;

import com.example.demo.Model.Endereco;
import com.example.demo.Model.Usuario;
import com.example.demo.Service.EnderecoService;
import com.example.demo.Service.UsuarioService;
import org.springframework.web.bind.annotation.*;

import java.math.BigInteger;
import java.util.List;

@RestController
@RequestMapping("/usuario")
public class UsuarioController {

    private final UsuarioService usuarioService;
    private final EnderecoService enderecoService;

    public UsuarioController(UsuarioService usuarioService, EnderecoService enderecoService) {
        this.usuarioService = usuarioService;
        this.enderecoService = enderecoService;
    }
    @GetMapping("/{id}")
    public Usuario getById(@PathVariable BigInteger id) {
        return usuarioService.getById(id);
    }

    @GetMapping
    public List<Usuario> getAll() {
        return usuarioService.getAll();
    }

    @PostMapping
    public Usuario create(@RequestBody Usuario usuario) {
        return usuarioService.save(usuario);
    }

    @PutMapping("/{id}")
    public Usuario update( @PathVariable BigInteger id, @RequestBody Usuario usuario) { return usuarioService.update(id, usuario);}

    //implementar autenticação de delete
    @DeleteMapping("/{id}")
    public void delete(@PathVariable BigInteger id) {
        usuarioService.delete(id);
    }

    //ENDEREÇO
    @GetMapping("/usuarios/{id}/endereco")
    public Endereco getEndereco(@PathVariable BigInteger id) {
        return enderecoService.buscarPorUsuario(id);
    }
}
