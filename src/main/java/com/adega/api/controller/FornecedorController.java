package com.adega.api.controller;

import com.adega.api.domain.fornecedor.Fornecedor;
import com.adega.api.domain.fornecedor.dto.DadosFornecedorCadastro;
import com.adega.api.domain.fornecedor.dto.DadosFornecedorAtualizar;
import com.adega.api.domain.fornecedor.dto.DadosList;
import com.adega.api.domain.fornecedor.dto.DadosListFornecedor;
import com.adega.api.service.fornecedor.FornecedorService;
import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.data.web.SpringDataWebProperties;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/fornecedor")
public class FornecedorController {
    @Autowired
    FornecedorService fornecedorService;

    @PostMapping("/cadastra")
    @Transactional
    public ResponseEntity<DadosFornecedorCadastro> cadastra(@RequestBody  @Valid DadosFornecedorCadastro dados){

        return fornecedorService.cadastraFornecedor(dados);

    }
    @PutMapping("/atualizar/{id}")
    @Transactional
    public ResponseEntity<DadosFornecedorAtualizar> atualizar(@PathVariable Long id,@RequestBody DadosFornecedorAtualizar atualizar){
        System.out.println(atualizar);
        return fornecedorService.atualizarForncedor(id,atualizar);

    }
    @GetMapping("/list")
    public Page<Fornecedor> list(@PageableDefault(size = 10, sort = {"nome"}) Pageable pageable, @RequestBody DadosList dadosList){
        return fornecedorService.listForncedor(pageable,dadosList);

    }
}
