package com.adega.api.domain.gestao.dto;

import jakarta.validation.constraints.PastOrPresent;
import jakarta.validation.constraints.PositiveOrZero;

import java.math.BigDecimal;
import java.time.LocalDate;

public record DadosListGanhoDispesa(
        @PositiveOrZero
        BigDecimal valor,
        CategoriaFinacas finacas,
        @PastOrPresent
        LocalDate date

) {
}
