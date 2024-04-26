package com.adega.api.repository;

import com.adega.api.domain.gestao.GestaoFinancas;
import com.adega.api.domain.gestao.dto.CategoriaFinacas;
import com.adega.api.domain.gestao.dto.Despesa;
import com.adega.api.domain.gestao.dto.Receita;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

public interface GestaoFinaceiraRepository extends JpaRepository<GestaoFinancas, Long> {

    @Query(value = "SELECT g.date as data,sum(g.valor) as total FROM GestaoFinancas g where g.finacas = 'DESPESA' group by g.date")
    List<Despesa> DESPESA();

    @Query(value = "SELECT g.date as data,sum(g.valor) as total FROM GestaoFinancas g where g.finacas = 'RECEITA' group by g.date")
    List<Receita> RECEITA();

    List<GestaoFinancas> findByDateBetween(LocalDate date1, LocalDate date2);

    @Query(value = "SELECT g.date as data,sum(g.valor) as total FROM GestaoFinancas g where g.finacas = 'DESPESA' AND g.date between ?1 and ?2 group by g.date")
    List<Despesa> DESPESADATE(LocalDate date1, LocalDate date2);

    @Query(value = "SELECT g.date as data,sum(g.valor) as total FROM GestaoFinancas g where g.finacas = 'RECEITA'  AND g.date between ?1 and ?2 group by g.date")
    List<Receita> RECEITADATE(LocalDate date1, LocalDate date2);

    List<GestaoFinancas> findByValorGreaterThanEqual(BigDecimal valor);

    List<GestaoFinancas> findByFinacas(CategoriaFinacas finacas);

    List<GestaoFinancas> findByValorGreaterThanEqualAndDateBetween(BigDecimal valor, LocalDate date1, LocalDate date2);
}
