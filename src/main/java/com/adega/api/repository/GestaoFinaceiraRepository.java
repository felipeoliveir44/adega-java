package com.adega.api.repository;

import com.adega.api.domain.gestao.GestaoFinancas;
import org.springframework.data.jpa.repository.JpaRepository;

public interface GestaoFinaceiraRepository extends JpaRepository<GestaoFinancas, Long> {
}
