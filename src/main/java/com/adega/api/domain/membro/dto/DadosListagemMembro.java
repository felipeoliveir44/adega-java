package com.adega.api.domain.membro.dto;

import com.adega.api.domain.membro.Membro;

import java.time.LocalDate;

public record DadosListagemMembro(
        String nome,
        String email,
        String cpf,
        LocalDate dataContratacao,
        LocalDate dataRenovacao

) {
    public DadosListagemMembro(Membro membro){
        this(membro.getNome(), membro.getEmail(), membro.getCpf(), membro.getDataContratacao(), membro.dataRenovacao());
    }
}
