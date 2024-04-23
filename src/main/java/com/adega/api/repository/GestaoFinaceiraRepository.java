package com.adega.api.repository;

import com.adega.api.domain.gestao.GestaoFinancas;
import com.adega.api.domain.gestao.dto.Despesa;
import com.adega.api.domain.gestao.dto.Receita;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.Optional;

public interface GestaoFinaceiraRepository extends JpaRepository<GestaoFinancas, Long> {

    @Query(value = "SELECT g.date as data,sum(g.valor) as total FROM GestaoFinancas g where g.finacas = 'DESPESA' group by g.date")
    Optional<Despesa> DESPESA();

    @Query(value = "SELECT g.date as data,sum(g.valor) as total FROM GestaoFinancas g where g.finacas = 'RECEITA' group by g.date")
    Optional<Receita> RECEITA();
}
