package com.example.demo.Controller;

import com.example.demo.Model.Endereco;
import com.example.demo.Model.Usuario;
import com.example.demo.Service.Implement.EnderecoServiceImpl;
import com.example.demo.Service.UsuarioService;
import org.springframework.web.bind.annotation.*;

import java.math.BigInteger;
import java.util.List;

@RestController
@RequestMapping("/usuario")
public class UsuarioController {

    private final UsuarioService usuarioService;
    private final EnderecoServiceImpl enderecoService;

    public UsuarioController(UsuarioService usuarioService, EnderecoServiceImpl enderecoService) {
        this.usuarioService = usuarioService;
        this.enderecoService = enderecoService;
    }
    @GetMapping("/{id}")
    public Usuario findById(@PathVariable Long id) {
        return usuarioService.findById(id);
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
    public Usuario update( @PathVariable Long id, @RequestBody Usuario usuario) { return usuarioService.update(id, usuario);}

    @PatchMapping("/{id}")
    public Usuario updatePartial(@PathVariable Long id, @RequestBody Usuario usuario) {
        return usuarioService.updatePartial(id, usuario);
    }

    //implementar autenticação de delete
    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        usuarioService.delete(id);
    }

    //ENDEREÇO
    @GetMapping("/usuarios/{id}/endereco")
    public Endereco getEndereco(@PathVariable Long id) {
        return enderecoService.buscarPorUsuario(id);
    }
}
