package com.adega.api.domain.cliente.dto;

import com.adega.api.domain.cliente.Cliente;

public record DadosListCliente(
        String name,
        String telefone
) {
    public DadosListCliente(Cliente cliente){
        this(cliente.getNome(), cliente.getTelefone());
    }
}
