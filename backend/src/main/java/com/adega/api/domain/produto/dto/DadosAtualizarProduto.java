package com.adega.api.domain.produto.dto;

import java.math.BigDecimal;

public record DadosAtualizarProduto(

        String nome,
        Integer quantidade,
        BigDecimal preco,
        Long idCategoria


) {
}
