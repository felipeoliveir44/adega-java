package com.adega.api.domain.produto.dto;

import java.math.BigDecimal;

public interface DadosListagemProdutosAleatorios {
    Long getId();
    String getNome();
    Integer getQuantidade();
    BigDecimal getPreco();
    BigDecimal getPrecoDesconto();
}

