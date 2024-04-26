package com.adega.api.domain.funcionario.dto;

import com.adega.api.domain.funcionario.Role;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import org.hibernate.validator.constraints.br.CPF;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDate;

public record DadosCadastrarFuncionario(
        @NotBlank
        String nome,
        @NotBlank
        String email,
        @NotBlank
        String senha,
        @NotBlank
        String telefone,
        @NotBlank
        String rg,
        @CPF
        String cpf,
        @DateTimeFormat(pattern = "dd/MM/yyyy")
        LocalDate dataContratacao,
        @DateTimeFormat(pattern = "dd/MM/yyyy")
        LocalDate dataNascimento,
        Role role

) {

}
