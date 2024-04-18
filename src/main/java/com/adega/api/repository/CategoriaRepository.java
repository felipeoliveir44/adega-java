package com.adega.api.repository;

import com.adega.api.domain.categoria.Categoria;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface CategoriaRepository extends JpaRepository<Categoria,Long> {

    Page<Categoria> findById(Long id,Pageable pageable);


    Page<Categoria> findByCategoria(String categoria, Pageable paginacao);
}
