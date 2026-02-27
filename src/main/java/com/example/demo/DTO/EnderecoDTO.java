package com.example.demo.DTO;

import com.example.demo.Model.Endereco;

public record EnderecoDTO(
        Long id,
        String logradouro,
        Integer numero,
        String complemento,
        String referencia,
        String bairro,
        String cep,
        String cidade,
        String estado,
        String pais
) {
    public EnderecoDTO(Endereco endereco) {
        this(
                endereco.getIdEndereco(),
                endereco.getLogradouro(),
                endereco.getNumero(),
                endereco.getComplemento(),
                endereco.getReferencia(),
                endereco.getBairro(),
                endereco.getCep(),
                endereco.getCidade(),
                endereco.getEstado(),
                endereco.getPais()
        );
    }
}