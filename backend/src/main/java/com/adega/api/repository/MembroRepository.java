package com.adega.api.repository;

import com.adega.api.domain.membro.Membro;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.security.core.userdetails.UserDetails;

public interface MembroRepository extends JpaRepository<Membro, Long> {
}
