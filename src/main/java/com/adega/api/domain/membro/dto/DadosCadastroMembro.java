package com.adega.api.domain.membro.dto;

import com.adega.api.domain.membro.EnumPlano;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import org.hibernate.validator.constraints.br.CPF;

import java.time.LocalDate;

public record DadosCadastroMembro(
        @NotBlank
        String nome,
        @Email
        String email,
        @NotBlank
        String senha,
        @CPF
        String cpf,
        @NotBlank
        String formaPagamento,
        @NotNull
        EnumPlano plano

) {

}
