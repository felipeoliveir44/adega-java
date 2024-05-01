package com.adega.api.domain.membro;

import com.adega.api.domain.membro.dto.DadosCadastroMembro;
import jakarta.persistence.*;
import lombok.*;
import org.springframework.cglib.core.Local;

import java.time.LocalDate;

@Entity
@Table(name = "tbmembro")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@EqualsAndHashCode(of = "id")
public class Membro {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "nome")
    private String nome;
    @Column(name = "email")
    private String email;
    @Column(name = "senha")
    private String senha;
    @Column(name = "cpf")
    private String cpf;
    @Column(name = "data_contratacao")
    private LocalDate dataContratacao;
    @Column(name = "data_renovacao")
    private LocalDate dataRenovacao;
    @Column(name = "forma_pagamento")
    private String formaPagamento;
    @JoinColumn(name = "id_plano")
    @Enumerated(EnumType.STRING)
    private EnumPlano plano;

    public Membro(DadosCadastroMembro dados, EnumPlano plano) {
        this.nome = dados.nome();
        this.email = dados.email();
        this.senha = dados.senha();
        this.cpf = dados.cpf();
        this.dataContratacao = LocalDate.now();
        this.dataRenovacao = dataRenovacao();
        this.formaPagamento = dados.formaPagamento();
        this.plano = plano;
    }


    public LocalDate dataRenovacao() {
        // Obter a data atual
        LocalDate dataAtual = LocalDate.now();
        // Adicionar 30 dias à data atual
        LocalDate dataRenovacao = dataAtual.plusDays(30);
        return dataRenovacao;
    }
}
