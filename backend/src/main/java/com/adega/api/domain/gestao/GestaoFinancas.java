package com.adega.api.domain.gestao;

import com.adega.api.domain.gestao.dto.CategoriaFinacas;
import com.adega.api.domain.gestao.dto.DadosGestaoFinancas;
import com.fasterxml.jackson.databind.annotation.EnumNaming;
import jakarta.persistence.*;
import lombok.*;

import java.math.BigDecimal;
import java.time.LocalDate;

@Entity
@Table(name = "tbGestaoFinancas")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(of = "id")
public class GestaoFinancas {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "valor")
    private BigDecimal valor;
    @Column(name = "finacas")
    @Enumerated(EnumType.STRING)
    private CategoriaFinacas finacas;
    @Column(name = "date")
    private LocalDate date;

    public GestaoFinancas(DadosGestaoFinancas dados) {
        this.valor = dados.valor();
        this.finacas = dados.financas();
        this.date = dados.date();
    }
}
