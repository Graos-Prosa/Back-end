package com.example.demo.DTO.Endereco;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

@Schema(description = "DTO para criação de endereço")
public record EnderecoCreateDTO(
        @NotNull
        @Schema(description = "ID do usuário", example = "1")
        Long idUsuario,
        @NotBlank
        @Schema(description = "Logradouro (rua, avenida, etc.)", example = "Rua das Flores")
        String logradouro,
        @NotNull
        @Min(1)
        @Schema(description = "Número do endereço", example = "123")
        Integer numero,
        @Schema(description = "Complemento do endereço", example = "Apto 101")
        String complemento,
        @Schema(description = "Ponto de referência", example = "Próximo ao mercado")
        String referencia,
        @NotBlank
        @Schema(description = "Bairro", example = "Centro")
        String bairro,
        @NotBlank
        @Schema(description = "CEP", example = "01001-000")
        String cep,
        @NotBlank
        @Schema(description = "Cidade", example = "Rio de Janeiro")
        String cidade,
        @NotBlank
        @Schema(description = "Estado (UF)", example = "RJ")
        String estado,
        @NotBlank
        @Schema(description = "País", example = "Brasil")
        String pais
) {}