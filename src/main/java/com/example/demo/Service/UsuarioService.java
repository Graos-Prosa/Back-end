package com.example.demo.Service;

import com.example.demo.DTO.Usuario.UsuarioCreateDTO;
import com.example.demo.DTO.Usuario.UsuarioDTO;
import com.example.demo.DTO.Usuario.UsuarioUpdateDTO;

import java.util.List;

public interface UsuarioService {
    UsuarioDTO findById(Long id);
    UsuarioDTO save(UsuarioCreateDTO dto);
    List<UsuarioDTO> findAll();
    UsuarioDTO update(Long id, UsuarioUpdateDTO dto);
    public void delete(Long id);
}
