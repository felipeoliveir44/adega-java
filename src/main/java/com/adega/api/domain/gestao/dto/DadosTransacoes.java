package com.adega.api.domain.gestao.dto;

import java.time.LocalDate;

public record DadosTransacoes(
        CategoriaFinacas categoriaFinacas,
        LocalDate date
) {
}
