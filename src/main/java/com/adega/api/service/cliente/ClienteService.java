package com.adega.api.service.cliente;

import com.adega.api.domain.cliente.Cliente;
import com.adega.api.domain.cliente.dto.DadosAtualizarCliente;
import com.adega.api.domain.cliente.dto.DadosCliente;
import com.adega.api.domain.cliente.dto.DadosListCliente;
import com.adega.api.domain.pedido.dto.DadosRealizarPedido;
import com.adega.api.repository.ClienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class ClienteService {
    @Autowired
    ClienteRepository clienteRepository;

    public ResponseEntity<DadosCliente> cadastrar(DadosCliente dados) {
        Cliente cliente = new Cliente(dados);
        clienteRepository.save(cliente);
        return ResponseEntity.ok().body(dados);
    }
    public Cliente cadastrarCliente(DadosRealizarPedido cliente) {
        var criarCliente = new Cliente(cliente);
        clienteRepository.save(criarCliente);
        return criarCliente;
    }
    public Page<DadosListCliente> listar(Pageable paginacao) {
        return clienteRepository.findAll(paginacao).map(DadosListCliente::new);
    }

    public ResponseEntity<DadosAtualizarCliente> atualizar(DadosAtualizarCliente atualizarCliente,Long id) {
        Optional<Cliente> optional = clienteRepository.findById(id);
        if(optional.isPresent()){
            optional.ifPresent(c-> c.atualizar(atualizarCliente));
        }else {
            throw new RuntimeException();
        }
        return ResponseEntity.ok().body(atualizarCliente);
    }
}
