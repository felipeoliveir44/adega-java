package com.adega.api.domain.cliente.dto;

import jakarta.validation.constraints.NotBlank;

public record DadosAtualizarCliente(
        @NotBlank
        String name,
        @NotBlank
        String telefone
) {
}
