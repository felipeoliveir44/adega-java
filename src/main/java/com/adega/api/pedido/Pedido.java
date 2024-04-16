package com.adega.api.pedido;

import com.adega.api.cliente.Cliente;
import com.adega.api.produto.Produto;
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
    private long id;
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

}
