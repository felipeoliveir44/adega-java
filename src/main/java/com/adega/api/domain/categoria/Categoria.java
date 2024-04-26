package com.adega.api.domain.categoria;

import com.adega.api.domain.categoria.dto.DadosCategoria;
import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "tbcategoria")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@EqualsAndHashCode(of = "id")
public class Categoria {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "nome",unique = true)
    private String categoria;

    public Categoria(DadosCategoria dadosCategoria) {
        this.categoria = dadosCategoria.nome().toUpperCase();
    }
}
