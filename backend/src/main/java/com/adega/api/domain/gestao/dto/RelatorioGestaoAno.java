package com.adega.api.domain.gestao.dto;

import java.math.BigDecimal;
import java.util.List;

public record RelatorioGestaoAno(
        List<Transacoes> transacoesList,
        BigDecimal valorTotal
) {
}
