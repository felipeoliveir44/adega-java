package com.adega.api.domain.fornecedor;

import com.adega.api.domain.fornecedor.dto.DadosFornecedorAtualizar;
import com.adega.api.domain.fornecedor.dto.DadosFornecedorCadastro;
import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "tbfornecedor")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@EqualsAndHashCode(of = "id")
public class Fornecedor {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name ="nome")
    private String nome;
    @Column(name = "email")
    private String email;
    @Column(name = "endereco")
    private String endereco;
    @Column(name = "telefone")
    private String telefone;

    public Fornecedor(DadosFornecedorCadastro dados) {
        this.nome= dados.nome();
        this.email =dados.email();
        this.endereco = dados.endereco();
        this.telefone = dados.telefone();
    }

    public void atualizarInfos(DadosFornecedorAtualizar atualizar) {
        if(atualizar.email() != null){
            this.email = atualizar.email() ;

        }
        if(atualizar.telefone() != null){
            this.telefone = atualizar.telefone();

        }
        if(atualizar.endereco() != null){
            this.endereco = atualizar.endereco();

        }

    }
}
