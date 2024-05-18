package com.adega.api.domain.funcionario;

import com.adega.api.domain.funcionario.dto.DadosAtualizarFuncionario;
import com.adega.api.domain.funcionario.dto.DadosCadastrarFuncionario;
import com.adega.api.domain.user.Role;
import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;

@Entity
@Table(name = "tbfuncionario")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@EqualsAndHashCode(of = "id")
public class Funcionario{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name ="nome")
    private String nome;
    @Column(name = "email")
    private String email;
    @Column(name = "telefone")
    private String telefone;
    @Column(name = "rg")
    private String rg;
    @Column(name = "cpf")
    private String cpf;
    @Column(name = "data_contratacao")
    private LocalDate dataContratacao;
    @Column(name = "data_nascimento")
    private LocalDate dataNascimento;
    @Column(name = "role")
    @Enumerated(EnumType.STRING)
    private Role role;
    @Column(name = "status")
    private Boolean status;

    public Funcionario(DadosCadastrarFuncionario dados) {
        this.nome = dados.nome();
        this.email = dados.email();
        this.telefone = dados.telefone();
        this.rg = dados.rg();
        this.cpf = dados.cpf();
        this.dataContratacao = dados.dataContratacao();
        this.dataNascimento = dados.dataNascimento();
        this.role = dados.role();
        this.status = true;
    }

    public Funcionario(DadosCadastrarFuncionario dados, String senhaCriptografada, Role role) {
        this.nome = dados.nome();
        this.email = dados.email();
        this.telefone = dados.telefone();
        this.rg = dados.rg();
        this.cpf = dados.cpf();
        this.dataContratacao = dados.dataContratacao();
        this.dataNascimento = dados.dataNascimento();
        this.role = dados.role();
        this.status = true;
    }


    public void desativaFuncionario(){
        this.status = false;
    }
    public void atualizarInformacoes(DadosAtualizarFuncionario dados) {
        if (dados.nome() != null) {
            this.nome = dados.nome();
        }

        if (dados.email() != null) {
            this.email = dados.email();
        }
        if (dados.telefone() != null) {
            this.telefone = dados.telefone();
        }
    }

    public void ativarFuncionario() {
        this.status = true;
    }

}
