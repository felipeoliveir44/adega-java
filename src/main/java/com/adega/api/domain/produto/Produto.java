package com.adega.api.domain.produto;

import com.adega.api.domain.categoria.Categoria;
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
public class Produto {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name ="nome")
    private String nome;
    @Column(name = "quantidade")
    private int quantidade;
    @Column(name = "preco")
    private BigDecimal preco;
    @ManyToOne
    @JoinColumn(name = "id_categoria")
    private Categoria idCatagoria;
}
