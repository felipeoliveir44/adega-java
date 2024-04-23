package com.adega.api.domain.gestao.dto;

import java.util.List;
import java.util.Optional;

public record RelatorioGestao(
        List<Transacoes> transacoesList,
        Optional<Despesa> despesatotal,
        Optional<Receita> receitatotal
) {
}
