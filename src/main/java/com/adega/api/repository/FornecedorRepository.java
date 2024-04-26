package com.adega.api.repository;

import com.adega.api.domain.categoria.Categoria;
import com.adega.api.domain.fornecedor.Fornecedor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FornecedorRepository extends JpaRepository<Fornecedor,Long> {

    Page<Fornecedor> findById(Long id, Pageable pageable);


    Page<Fornecedor> findByNomeContaining(String categoria, Pageable paginacao);
}
