package com.adega.api.repository;

import com.adega.api.domain.gestao.GestaoFinancas;
import com.adega.api.domain.gestao.dto.CategoriaFinacas;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;

public interface GestaoFinaceiraRepository extends JpaRepository<GestaoFinancas, Long> {

    List<GestaoFinancas> findByDateBetween(LocalDate date1, LocalDate date2);

    List<GestaoFinancas> findByValorGreaterThanEqual(BigDecimal valor);

    List<GestaoFinancas> findByFinacas(CategoriaFinacas finacas);

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
