package com.adega.api.domain.pedido;

import com.adega.api.domain.cliente.Cliente;
import com.adega.api.domain.cliente.dto.DadosCliente;
import com.adega.api.domain.pedido.dto.DadosRealizarPedido;
import com.adega.api.domain.produto.Produto;
import jakarta.persistence.*;
import lombok.*;

import java.math.BigDecimal;

@Entity
@Table(name = "tbpedido")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@EqualsAndHashCode(of = "id")
public class Pedido {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "quantidade")
    private int quantidade;
    @Column(name = "preco_produto")
    private BigDecimal preco;
    @Column(name = " valor_total")
    private BigDecimal valorTotal;
    @ManyToOne
    @JoinColumn(name = "id_cliente")
    private Cliente cliente;
    @ManyToOne
    @JoinColumn(name = "id_produto")
    private Produto produto;

    public Pedido(Cliente cliente, Produto produto, int quantidade, BigDecimal precoProduto, BigDecimal valorTotal) {
        this.cliente = cliente;
        this.produto = produto;
        this.quantidade = quantidade;
        this.preco = precoProduto;
        this.valorTotal = valorTotal;
    }

    public Pedido(DadosRealizarPedido pedido, Cliente cliente, Produto produto) {
        this.cliente = cliente;
        this.produto = produto;
        this.quantidade = pedido.quantidade();
        this.preco = pedido.precoProduto();
        this.valorTotal = pedido.valorTotal();
    }


}
