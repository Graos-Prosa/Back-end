package com.example.demo.DTO.Endereco;

import com.example.demo.Model.Endereco;
import io.swagger.v3.oas.annotations.media.Schema;

@Schema(description = "DTO de retorno do endereço")
public record EnderecoDTO(
        @Schema(description = "ID do endereço", example = "1")
        Long id,
        @Schema(description = "ID do usuário", example = "1")
        Long idUsuario,
        @Schema(description = "Logradouro", example = "Rua das Flores")
        String logradouro,
        @Schema(description = "Número", example = "123")
        Integer numero,
        @Schema(description = "Complemento", example = "Apto 101")
        String complemento,
        @Schema(description = "Referência", example = "Próximo ao mercado")
        String referencia,
        @Schema(description = "Bairro", example = "Centro")
        String bairro,
        @Schema(description = "CEP", example = "01001-000")
        String cep,
        @Schema(description = "Cidade", example = "Rio de Janeiro")
        String cidade,
        @Schema(description = "Estado (UF)", example = "RJ")
        String estado,
        @Schema(description = "País", example = "Brasil")
        String pais
) {
    public EnderecoDTO(Endereco endereco) {
        this(
                endereco.getIdEndereco(),
                endereco.getUsuario().getIdUsuario(),
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