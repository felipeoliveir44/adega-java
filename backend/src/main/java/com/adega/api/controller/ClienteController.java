package com.adega.api.controller;

import com.adega.api.domain.cliente.dto.DadosAtualizarCliente;
import com.adega.api.domain.cliente.dto.DadosCliente;
import com.adega.api.domain.cliente.dto.DadosListCliente;
import com.adega.api.service.cliente.ClienteService;
import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/cliente")
public class ClienteController {
    @Autowired
    ClienteService service;
    @PostMapping("/cadastro")
    @Transactional
    public ResponseEntity<DadosCliente> cadastrar(@RequestBody @Valid DadosCliente dados) {
        return service.cadastrar(dados);
    }
    @GetMapping("/lista")
    public Page<DadosListCliente> list(@PageableDefault(size = 10, sort = {"nome"}) Pageable paginacao){
        return service.listar(paginacao);
    }
    @PutMapping("/atualizar/{id}")
    @Transactional
    public ResponseEntity<DadosAtualizarCliente> atualizar(@PathVariable Long id,@RequestBody @Valid DadosAtualizarCliente atualizarCliente){
        return service.atualizar(atualizarCliente,id);
    }
}
