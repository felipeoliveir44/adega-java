package com.adega.api.domain.membro.dto;

import com.adega.api.domain.membro.EnumPlano;
import com.adega.api.domain.user.Role;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import org.hibernate.validator.constraints.br.CPF;

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
        EnumPlano plano,
        Role role

) {

}
