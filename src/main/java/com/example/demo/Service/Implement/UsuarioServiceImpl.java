package com.example.demo.Service.Implement;

import com.example.demo.Model.Usuario;
import com.example.demo.Repository.UsuarioRepository;
import com.example.demo.Service.UsuarioService;
import org.springframework.stereotype.Service;

import java.math.BigInteger;
import java.util.List;

@Service
public class UsuarioServiceImpl implements UsuarioService {

    private final UsuarioRepository usuarioRepository;

    public UsuarioServiceImpl(UsuarioRepository usuarioRepository) {
        this.usuarioRepository = usuarioRepository;
    }

    @Override
    public Usuario findById(Long id) {
        return usuarioRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Usuario não encontrado."));
    }

    @Override
    public List<Usuario> getAll() {
        return usuarioRepository.findAll();
    }

    @Override
    public Usuario save(Usuario usuario) {
        return usuarioRepository.save(usuario);
    }

    //implementar metodo de update
    @Override
    public Usuario update(Long id, Usuario usuario) {
        return null;
    }

    @Override
    public void delete(Long id) {
        usuarioRepository.deleteById(id);
    }
}
