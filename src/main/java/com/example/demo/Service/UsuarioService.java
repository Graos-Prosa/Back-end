package com.example.demo.Service;

import com.example.demo.Model.Usuario;

import java.math.BigInteger;
import java.util.List;

public interface UsuarioService {
    public Usuario getById(BigInteger id);
    public List<Usuario> getAll();
    public Usuario save(Usuario usuario);
    public Usuario update(BigInteger id, Usuario usuario);
    public void delete(BigInteger id);
}
