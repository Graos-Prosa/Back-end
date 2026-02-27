package com.example.demo.DTO;

import com.example.demo.Model.Usuario;
import java.util.List;

public record UsuarioDTO(
        //precisa do id pq no front-end ele pode editar o objeto
        Long id,
        String nome,
        String sobrenome,
        String telefone,
        List<EnderecoDTO> enderecos
) {
    public UsuarioDTO(Usuario usuario) {
        this(
                usuario.getIdUsuario(),
                usuario.getNome(),
                usuario.getSobrenome(),
                usuario.getTelefone(),
                usuario.getEnderecos()
                        .stream() // percorre a lista
                        .map(EnderecoDTO::new) // transforma cada item
                        .toList() // retorna uma nova lista com os itens transformados
        );
    }
}

//stream() “quero trabalhar item por item”
//map() “para cada item, transforme em outra coisa”
//toList() “me devolva tudo como uma nova lista”