package com.adega.api.domain.gestao.dto;

import java.math.BigDecimal;
import java.time.LocalDate;

public record DadosGestaoFinancas(

         BigDecimal valor,
         CategoriaFinacas financas,
         LocalDate date



) {
}
