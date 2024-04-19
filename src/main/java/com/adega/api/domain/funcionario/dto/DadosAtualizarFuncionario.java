package com.adega.api.domain.funcionario.dto;

import jakarta.validation.constraints.NotNull;

public record DadosAtualizarFuncionario(
        @NotNull
        Long id,
        String nome,
        String email,
        String senha,
        String telefone
) {
}
