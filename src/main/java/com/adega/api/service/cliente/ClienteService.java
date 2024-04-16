package com.adega.api.service.cliente;

import com.adega.api.domain.cliente.Cliente;
import com.adega.api.domain.cliente.dto.DadosCliente;
import com.adega.api.repository.ClienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public class ClienteService {
    @Autowired
    ClienteRepository clienteRepository;
    public ResponseEntity<DadosCliente> cadastrar(DadosCliente dados) {
        Cliente cliente = new Cliente(dados);
        clienteRepository.save(cliente);
        return ResponseEntity.ok().body(dados);
    }
}
