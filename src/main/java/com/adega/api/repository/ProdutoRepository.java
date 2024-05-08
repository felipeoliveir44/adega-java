package com.adega.api.repository;

import com.adega.api.domain.produto.Produto;
import com.adega.api.domain.produto.dto.DadosListagemProdutosAleatorios;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.math.BigDecimal;
import java.util.List;

public interface ProdutoRepository extends JpaRepository<Produto,Long> {

    Page<Produto> findById(Long id,Pageable pageable);

    Page<Produto> findByNomeContaining(String nome, Pageable pageable);

    Page<Produto> findByPrecoGreaterThanEqual(BigDecimal preco, Pageable pageable);

    Page<Produto> findByQuantidadeGreaterThanEqual(Integer quantidade, Pageable pageable);

    List<Produto> findQuantidadeById(Long id);
    @Query("SELECT p.id as id, p.nome as nome, p.quantidade as quantidade, p.preco as preco, (p.preco - (p.preco * 0.3)) as precoDesconto FROM Produto p ORDER BY RAND() LIMIT 3")
    List<DadosListagemProdutosAleatorios> retornarItemAleatorio();
}
