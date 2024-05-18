package com.adega.api.domain.pedido.dto;

import com.adega.api.domain.cliente.Cliente;
import com.adega.api.domain.cliente.dto.DadosCliente;
import com.adega.api.domain.produto.Produto;
import jakarta.validation.constraints.NotNull;
import org.aspectj.weaver.ast.Not;

import java.math.BigDecimal;

public record DadosRealizarPedido(
        String nome,
        String cpf,
        String telefone,
        @NotNull
        Long idProduto,
        @NotNull
        int quantidade,
        @NotNull
        BigDecimal precoProduto,
        @NotNull
        BigDecimal valorTotal
) {

}
