package com.adega.api.categoria;

import com.adega.api.categoria.model.NameCatrgoria;
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
    private long id;
    @Enumerated(EnumType.STRING)
    @Column(name = "nome")
    private NameCatrgoria categoria;
}
