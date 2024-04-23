package com.adega.api.service.pedido;

import com.adega.api.domain.cliente.Cliente;
import com.adega.api.domain.pedido.Pedido;
import com.adega.api.domain.pedido.dto.DadosRealizarPedido;
import com.adega.api.domain.produto.Produto;
import com.adega.api.repository.ClienteRepository;
import com.adega.api.repository.PedidoRepository;
import com.adega.api.repository.ProdutoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.Optional;

@Service
public class PedidoService {

    @Autowired
    private PedidoRepository pedidoRepository;
    @Autowired
    private ProdutoRepository produtoRepository;
    @Autowired
    private ClienteRepository clienteRepository;
    public ResponseEntity realizarPedido(DadosRealizarPedido dados) {
        var criarCliente = cadastrarCliente(dados);
        System.out.println(criarCliente);
        var produto = produtoRepository.getReferenceById(dados.idProduto());
        var pedido = new Pedido(criarCliente, produto, dados.quantidade(), dados.precoProduto(), dados.valorTotal());
        retirarQuantidadeProduto(dados);
        pedidoRepository.save(pedido);
        return ResponseEntity.ok().body(pedido);
    }

    public Cliente cadastrarCliente(DadosRealizarPedido cliente) {
        var criarCliente = new Cliente(cliente);
        clienteRepository.save(criarCliente);
        return criarCliente;
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
