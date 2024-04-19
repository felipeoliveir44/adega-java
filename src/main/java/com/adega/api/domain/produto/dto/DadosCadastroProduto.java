package com.adega.api.domain.produto.dto;

import jakarta.validation.constraints.NotBlank;

import java.math.BigDecimal;

public record DadosCadastroProduto(
        @NotBlank
        String nome,
        @NotBlank

        Integer quantidade,
        @NotBlank

        BigDecimal preco,
        @NotBlank

        Long idCategoria



) {
}
