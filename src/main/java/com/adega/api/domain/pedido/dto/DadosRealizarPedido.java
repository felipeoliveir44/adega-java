package com.adega.api.domain.pedido.dto;

import com.adega.api.domain.cliente.Cliente;
import com.adega.api.domain.cliente.dto.DadosCliente;
import com.adega.api.domain.produto.Produto;

import java.math.BigDecimal;

public record DadosRealizarPedido(
        String nome,
        String cpf,
        String telefone,
        Long idProduto,
        int quantidade,
        BigDecimal precoProduto,
        BigDecimal valorTotal
) {

}
