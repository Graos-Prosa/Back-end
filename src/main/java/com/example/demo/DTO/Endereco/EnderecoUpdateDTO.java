package com.example.demo.DTO.Endereco;

import io.swagger.v3.oas.annotations.media.Schema;

@Schema(description = "DTO para atualização de endereço")
public record EnderecoUpdateDTO(
        @Schema(description = "Logradouro", example = "Rua Nova")
        String logradouro,
        @Schema(description = "Número", example = "456")
        Integer numero,
        @Schema(description = "Complemento", example = "Casa")
        String complemento,
        @Schema(description = "Referência", example = "Ao lado da farmácia")
        String referencia,
        @Schema(description = "Bairro", example = "Jardim")
        String bairro,
        @Schema(description = "CEP", example = "02002-000")
        String cep,
        @Schema(description = "Cidade", example = "Rio de Janeiro")
        String cidade,
        @Schema(description = "Estado (UF)", example = "RJ")
        String estado,
        @Schema(description = "País", example = "Brasil")
        String pais
) {}