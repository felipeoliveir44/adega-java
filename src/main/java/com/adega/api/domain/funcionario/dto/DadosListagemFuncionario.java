package com.adega.api.domain.funcionario.dto;

import com.adega.api.domain.funcionario.Funcionario;

import java.time.LocalDate;

public record DadosListagemFuncionario(
        String nome,
        String email,
        String telefone,
        String cpf,
        LocalDate dataContratacao,
        Boolean status
) {

    public DadosListagemFuncionario(Funcionario funcionario) {
        this(funcionario.getNome(), funcionario.getEmail(), funcionario.getTelefone(), funcionario.getCpf(), funcionario.getDataContratacao(), funcionario.getStatus());
    }

}
