package com.adega.api.domain.categoria.dto;

import jakarta.validation.constraints.NotBlank;

public record DadosCategoria(
        @NotBlank
        String nome
) {
}
