package com.adega.api.controller;

import com.adega.api.domain.cliente.dto.DadosCliente;
import com.adega.api.domain.pedido.dto.DadosRealizarPedido;
import com.adega.api.service.pedido.PedidoService;
import jakarta.validation.Valid;
import org.apache.coyote.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/pdv")
public class PedidoController {
    @Autowired
    private PedidoService service;
    @PostMapping
    @Transactional
    public ResponseEntity realizarPedido(@RequestBody @Valid DadosRealizarPedido pedido) {
        service.realizarPedido(pedido);
        return ResponseEntity.status(HttpStatus.CREATED).body(pedido);
    }
    
}
