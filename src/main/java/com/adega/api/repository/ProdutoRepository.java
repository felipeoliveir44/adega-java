package com.adega.api.repository;

import com.adega.api.domain.produto.Produto;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import java.math.BigDecimal;
import java.util.Optional;

public interface ProdutoRepository extends JpaRepository<Produto,Long> {

    Page<Produto> findById(Long id,Pageable pageable);

    Page<Produto> findByNomeContaining(String nome, Pageable pageable);

    Page<Produto> findByPrecoGreaterThanEqual(BigDecimal preco, Pageable pageable);

    Page<Produto> findByQuantidadeGreaterThanEqual(Integer quantidade, Pageable pageable);
}
