package com.adega.api.domain.gestao.dto;

import com.adega.api.domain.gestao.GestaoFinancas;
import jakarta.persistence.Column;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;

import java.math.BigDecimal;
import java.time.LocalDate;

public record Transacoes(
         BigDecimal valor,
         CategoriaFinacas finacas,
         LocalDate date
) {
    public Transacoes(GestaoFinancas financas){
        this(financas.getValor(),financas.getFinacas(),financas.getDate());
    }
}
