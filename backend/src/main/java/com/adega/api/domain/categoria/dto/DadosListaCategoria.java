package com.adega.api.domain.categoria.dto;

import com.adega.api.domain.categoria.Categoria;
import com.adega.api.domain.cliente.dto.DadosListCliente;

public record DadosListaCategoria(
        Long id,
        String nome

) {
    public DadosListaCategoria(Categoria categoria){
        this(categoria.getId(), categoria.getCategoria());
    }


}
