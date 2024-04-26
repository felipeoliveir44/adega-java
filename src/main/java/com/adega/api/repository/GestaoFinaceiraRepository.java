package com.adega.api.repository;

import com.adega.api.domain.gestao.GestaoFinancas;
import com.adega.api.domain.gestao.dto.CategoriaFinacas;
import com.adega.api.domain.gestao.dto.Despesa;
import com.adega.api.domain.gestao.dto.Receita;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;

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

    @Query(value = "SELECT sum(g.valor) FROM GestaoFinancas g WHERE g.finacas = ?1")
    BigDecimal valortotal(CategoriaFinacas finacas);

    List<GestaoFinancas> findByFinacasAndValorGreaterThanEqualAndDateBetween(CategoriaFinacas finacas, BigDecimal valor, LocalDate date1, LocalDate date2);

    @Query(value = "SELECT sum(g.valor) FROM GestaoFinancas g WHERE g.finacas = ?1 And g.valor >= ?2 And  g.date between ?3 and ?4")
    BigDecimal valorTotalAno(CategoriaFinacas finacas, BigDecimal valor, LocalDate date1, LocalDate date2);
    @Query(value = "SELECT sum(g.valor) FROM GestaoFinancas g WHERE g.finacas = ?1 And  g.date between ?2 and ?3")
    BigDecimal valorTotalCategoriaAno(CategoriaFinacas finacas, LocalDate date1, LocalDate date2);

    List<GestaoFinancas> findByFinacasAndDateBetween(CategoriaFinacas finacas, LocalDate date1, LocalDate date2);

    List<GestaoFinancas> findByDateBetweenAndValorGreaterThanEqual(LocalDate date1, LocalDate date2, BigDecimal valor);
}
