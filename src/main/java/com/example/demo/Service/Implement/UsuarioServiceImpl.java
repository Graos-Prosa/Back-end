package com.example.demo.Service.Implement;

import com.example.demo.DTO.UsuarioCreateDTO;
import com.example.demo.DTO.UsuarioDTO;
import com.example.demo.DTO.UsuarioUpdateDTO;
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
    public UsuarioDTO findById(Long id) {
        Usuario usuario = usuarioRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Usuário não encontrado"));

        return new UsuarioDTO(usuario);
    }

    @Override
    public List<UsuarioDTO> findAll() {
        return usuarioRepository.findAll().stream().map(UsuarioDTO::new).toList();
        //stream() “quero trabalhar item por item”
        //map() “para cada item, transforme em outra coisa”
        //toList() “me devolva tudo como uma nova lista”
    }

    @Override
    public UsuarioDTO save(UsuarioCreateDTO dto) {

        Usuario usuario = new Usuario();
        usuario.setNome(dto.nome());
        usuario.setSobrenome(dto.sobrenome());
        usuario.setTelefone(dto.telefone());

        Usuario salvo = usuarioRepository.save(usuario);

        return new UsuarioDTO(salvo);
    }

    //implementar metodo de update
    @Override
    public UsuarioDTO update(Long id, UsuarioUpdateDTO dto) {

        Usuario usuario = usuarioRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Usuário não encontrado"));

        usuario.setNome(dto.nome());
        usuario.setSobrenome(dto.sobrenome());
        usuario.setTelefone(dto.telefone());

        Usuario atualizado = usuarioRepository.save(usuario);

        return new UsuarioDTO(atualizado);
    }

    @Override
    public UsuarioDTO updatePartial(Long id, UsuarioDTO dto) {

        Usuario usuario = usuarioRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Usuário não encontrado"));

        if (dto.nome() != null) {
            usuario.setNome(dto.nome());
        }

        if (dto.sobrenome() != null) {
            usuario.setSobrenome(dto.sobrenome());
        }

        if (dto.telefone() != null) {
            usuario.setTelefone(dto.telefone());
        }

        Usuario atualizado = usuarioRepository.save(usuario);

        return new UsuarioDTO(atualizado);
    }

    @Override
    public void delete(Long id) {
        usuarioRepository.deleteById(id);
    }
}
