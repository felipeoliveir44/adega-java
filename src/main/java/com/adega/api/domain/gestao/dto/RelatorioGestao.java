package com.adega.api.domain.gestao.dto;

import java.util.List;

public record RelatorioGestao(
        List<Transacoes> transacoesList,
        Despesa despesatotal,
        Receita receitatotal
) {
}