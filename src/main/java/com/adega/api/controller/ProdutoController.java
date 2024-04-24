package com.adega.api.controller;

import com.adega.api.domain.produto.dto.DadosAtualizarProduto;
import com.adega.api.domain.produto.dto.DadosCadastroProduto;
import com.adega.api.domain.produto.dto.DadosListProduto;
import com.adega.api.service.produto.ProdutoService;
import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.data.web.SpringDataWebProperties;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RequestMapping("/produto")
@RestController
public class ProdutoController {
    @Autowired
    ProdutoService produtoService;

    @PostMapping("/cadastra")
    @Transactional
    public ResponseEntity<DadosCadastroProduto> cadastro(@RequestBody  @Valid DadosCadastroProduto dadosCadastroProduto){
        return produtoService.cadastroProduto(dadosCadastroProduto);

    }

    @GetMapping("/listar")
    public Page<DadosListProduto> listProdutos(@PageableDefault(size = 10,sort = {"preco"}) Pageable pageable, @RequestBody DadosListProduto dados){
        return produtoService.listProduto(pageable,dados);
    }

    @PutMapping("/atualizar/{id}")
    @Transactional
    public ResponseEntity<DadosAtualizarProduto> atualizar(@PathVariable Long id ,@RequestBody DadosAtualizarProduto atualizarProduto){
        return produtoService.atualizarProduto(id ,atualizarProduto);

    }
}
