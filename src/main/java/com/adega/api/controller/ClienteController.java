package com.adega.api.controller;

import com.adega.api.domain.cliente.dto.DadosCliente;
import com.adega.api.service.cliente.ClienteService;
import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
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
        service.cadastrar(dados);
        return ResponseEntity.ok().body(dados);
    }
}
