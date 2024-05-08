package com.adega.api.repository;

import com.adega.api.domain.membro.Membro;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MembroRepository extends JpaRepository<Membro, Long> {
}
