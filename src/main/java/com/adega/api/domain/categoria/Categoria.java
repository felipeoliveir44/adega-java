package com.adega.api.domain.categoria;

import com.adega.api.domain.categoria.model.NameCategoria;
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
    @Enumerated(EnumType.STRING)
    @Column(name = "nome")
    private NameCategoria categoria;
}
