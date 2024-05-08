package com.adega.api.domain.produto;

import com.adega.api.domain.categoria.Categoria;
import com.adega.api.domain.produto.dto.DadosAtualizarProduto;
import com.adega.api.domain.produto.dto.DadosCadastroProduto;
import jakarta.persistence.*;
import lombok.*;

import java.math.BigDecimal;

@Entity
@Table(name = "tbproduto")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@EqualsAndHashCode(of = "id")
@ToString
public class Produto {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name ="nome")
    private String nome;
    @Column(name = "quantidade")
    private Integer quantidade;
    @Column(name = "preco")
    private BigDecimal preco;
    @ManyToOne
    @JoinColumn(name = "id_categoria")
    private Categoria id_categoria;

    public Produto(DadosCadastroProduto dadosCadastroProduto, Categoria categoria) {
        this.nome = dadosCadastroProduto.nome();
        this.quantidade = dadosCadastroProduto.quantidade();
        this.preco = dadosCadastroProduto.preco();
        this.id_categoria = categoria;
    }



    public void atualizar(DadosAtualizarProduto atualizarProduto,Categoria categoria) {

        if(atualizarProduto.idCategoria() != null){
            this.id_categoria = categoria;

        }
        if(atualizarProduto.preco() != null){
            this.preco = atualizarProduto.preco();

        }
        if(atualizarProduto.nome() != null){
            this.nome = atualizarProduto.nome();

        }
        if(atualizarProduto.quantidade() != null){
            this.quantidade = atualizarProduto.quantidade();

        }

    }
}
