package com.adega.api.repository;

import com.adega.api.domain.funcionario.Funcionario;
import com.adega.api.domain.funcionario.dto.DadosListagemFuncionario;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.security.core.userdetails.UserDetails;

public interface FuncionarioRepository extends JpaRepository<Funcionario, Long> {
    Page<Funcionario> findAll(Pageable paginacao);
    UserDetails findByEmail(String email);
}
