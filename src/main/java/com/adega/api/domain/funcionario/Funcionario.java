package com.adega.api.domain.funcionario;

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
public class Funcionario {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name ="nome")
    private String nome;
    @Column(name = "email")
    private String email;
    @Column(name = "senha")
    private String senha;
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
    private String role;
    @Column(name = "status")
    private Boolean status;
    /*
    id bigint auto_increment primary key not null,
    nome varchar (100) not null,
    email varchar (100) not null unique,
    senha varchar (20) not null,
    telefone varchar (15) not null unique,
    rg varchar (12) not null unique,
    cpf varchar (15) not null unique,
    data_contratacao date not null,
    data_nascimento date not null,
    role varchar (20) not null,
    status tinyint not null

     */
    public void desativaFuncionario(){
        this.status = false;
    }
}
