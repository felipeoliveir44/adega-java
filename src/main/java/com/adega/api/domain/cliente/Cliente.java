package com.adega.api.domain.cliente;

import com.adega.api.domain.cliente.dto.DadosAtualizarCliente;
import com.adega.api.domain.cliente.dto.DadosCliente;
import com.adega.api.domain.pedido.dto.DadosRealizarPedido;
import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "tbcliente")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@EqualsAndHashCode(of = "id")
public class Cliente {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name ="nome")
    private String nome;
    @Column(name = "cpf")
    private String cpf;
    @Column(name = "telefone")
    private String telefone;

    public Cliente(DadosCliente cliente) {
        this.nome = cliente.nome();
        this.cpf = cliente.cpf();
        this.telefone = cliente.telefone();
    }
    public Cliente(DadosRealizarPedido cliente){
        this.nome = cliente.nome();
        this.cpf = cliente.cpf();
        this.telefone = cliente.telefone();
    }




    public void atualizar(DadosAtualizarCliente atualizarCliente) {
        if(atualizarCliente.name() != null||atualizarCliente.name().length()>1){
            this.nome = atualizarCliente.name();

        }
        if(atualizarCliente.telefone() != null||atualizarCliente.telefone().length()>1){
            this.telefone = atualizarCliente.telefone();

        }
    }
}
