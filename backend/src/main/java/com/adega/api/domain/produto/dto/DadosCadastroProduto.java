package com.adega.api.domain.produto.dto;

import com.fasterxml.jackson.annotation.JsonAlias;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

import java.math.BigDecimal;

public record DadosCadastroProduto(
        @NotBlank
        String nome,
        @NotNull
        Integer quantidade,
        @NotNull
        BigDecimal preco,
        @JsonAlias("id_categoria")
        @NotNull
        Long idCategoria
) {
}
