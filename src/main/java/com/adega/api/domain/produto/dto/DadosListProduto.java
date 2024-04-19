package com.adega.api.domain.produto.dto;

import com.adega.api.domain.produto.Produto;

import java.math.BigDecimal;

public record DadosListProduto(
        String nome,
        Integer quantidade,
        BigDecimal preco,
        Long id


) {
    public DadosListProduto(Produto produto){
        this(produto.getNome(), produto.getQuantidade(), produto.getPreco(), produto.getId());
    }
}
