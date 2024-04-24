package com.adega.api.service.produto;

import com.adega.api.domain.categoria.Categoria;
import com.adega.api.domain.pedido.dto.DadosRealizarPedido;
import com.adega.api.domain.produto.Produto;
import com.adega.api.domain.produto.dto.DadosAtualizarProduto;
import com.adega.api.domain.produto.dto.DadosCadastroProduto;
import com.adega.api.domain.produto.dto.DadosListProduto;
import com.adega.api.repository.CategoriaRepository;
import com.adega.api.repository.ProdutoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.data.web.SpringDataWebProperties;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class ProdutoService {
    @Autowired
    ProdutoRepository produtoRepository;
    @Autowired
    CategoriaRepository categoriaRepository;


    public ResponseEntity<DadosCadastroProduto> cadastroProduto(DadosCadastroProduto dadosCadastroProduto) {
       Optional<Categoria> categoria = categoriaRepository.findById(dadosCadastroProduto.idCategoria());
       if(categoria.isPresent()){
           produtoRepository.save(new Produto(dadosCadastroProduto,categoria.get()));
           return ResponseEntity.ok().body(dadosCadastroProduto);
       }else{
           throw new RuntimeException("CATEGORIA NÃO VALIDA");
       }
    }

    public Page<DadosListProduto> listProduto(Pageable pageable, DadosListProduto dados) {
        if(dados.id()!=null){
            return produtoRepository.findById(dados.id(),pageable).map(DadosListProduto::new);
        }else if(dados.nome()!=null){
            return produtoRepository.findByNomeContaining(dados.nome(),pageable).map(DadosListProduto::new);
        }else if(dados.preco()!=null){
            return produtoRepository.findByPrecoGreaterThanEqual(dados.preco(),pageable).map(DadosListProduto::new);
        }else if(dados.quantidade()!=null){
            return produtoRepository.findByQuantidadeGreaterThanEqual(dados.quantidade(),pageable).map(DadosListProduto::new);
        }else{
            return produtoRepository.findAll(pageable).map(DadosListProduto::new);

        }

    }

    public ResponseEntity<DadosAtualizarProduto> atualizarProduto(Long id, DadosAtualizarProduto atualizarProduto) {
        Optional<Categoria> categoria = categoriaRepository.findById(atualizarProduto.idCategoria());
        Optional<Produto>  produto = produtoRepository.findById(id);
        if(produto.isPresent()){
            if (categoria.isEmpty()) {
                produto.ifPresent(p->p.atualizar(atualizarProduto,null));

            } else {
                produto.ifPresent(p->p.atualizar(atualizarProduto,categoria.get()));

            }
            return ResponseEntity.ok().body(atualizarProduto);
        }else{
            throw new RuntimeException("NÃO ENCONTRADO PRODUTO OU CATEGORIA");
        }
    }

    public void retirarQuantidadeProduto(DadosRealizarPedido dados) {
        // Recuperar quantidade
        Optional<Produto> optionalProduto = produtoRepository.findById(dados.idProduto());
        Integer quantidadeRetirada = dados.quantidade();

        if (optionalProduto.isPresent()) {
            Produto produto = optionalProduto.get();
            Integer quantidadeAtual = produto.getQuantidade();

            if (quantidadeAtual >= quantidadeRetirada) {
                produto.setQuantidade(quantidadeAtual - quantidadeRetirada);
                produtoRepository.save(produto);
            } else {
                System.out.println("Não há estoque suficiente para retirar a quantidade solicitada.");
            }
        } else {
            System.out.println("Produto não encontrado com o ID especificado.");
        }
    }

}
