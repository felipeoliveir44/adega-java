package com.adega.api.domain.gestao.dto;

import java.util.List;

public record RelatorioGestao(
        List<Transacoes> transacoesList,
        List<Despesa> despesatotal,
        List<Receita> receitatotal
) {
}
