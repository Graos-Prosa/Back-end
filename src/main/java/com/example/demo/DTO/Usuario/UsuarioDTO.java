package com.example.demo.DTO.Usuario;

import com.example.demo.DTO.Endereco.EnderecoDTO;
import com.example.demo.Model.Usuario;
import io.swagger.v3.oas.annotations.media.Schema;

import java.time.LocalDate;
import java.util.List;

@Schema(description = "DTO de retorno do usuário")
public record UsuarioDTO(
        @Schema(description = "ID do usuário", example = "1")
        Long id,
        @Schema(description = "Nome do usuário", example = "João")
        String nome,
        @Schema(description = "Sobrenome do usuário", example = "Silva")
        String sobrenome,
        @Schema(description = "Telefone do usuário", example = "11999999999")
        String telefone,
        @Schema(description = "Data de aniversário", example = "01-01-2000")
        LocalDate aniversario,
        @Schema(description = "Lista de endereços do usuário")
        List<EnderecoDTO> enderecos
) {
    public UsuarioDTO(Usuario usuario) {
        this(
                usuario.getIdUsuario(),
                usuario.getNome(),
                usuario.getSobrenome(),
                usuario.getTelefone(),
                usuario.getAniversario(),
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