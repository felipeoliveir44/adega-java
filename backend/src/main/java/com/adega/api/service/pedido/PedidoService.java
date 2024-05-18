package com.adega.api.service.pedido;

import com.adega.api.domain.cliente.Cliente;
import com.adega.api.domain.pedido.Pedido;
import com.adega.api.domain.pedido.dto.DadosRealizarPedido;
import com.adega.api.domain.produto.Produto;
import com.adega.api.repository.ClienteRepository;
import com.adega.api.repository.PedidoRepository;
import com.adega.api.repository.ProdutoRepository;
import com.adega.api.service.cliente.ClienteService;
import com.adega.api.service.produto.ProdutoService;
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
    @Autowired
    private ProdutoService produtoService;
    @Autowired
    private ClienteService clienteService;
    public void realizarPedido(DadosRealizarPedido dados) {
        var criarCliente = clienteService.cadastrarCliente(dados);
        System.out.println(criarCliente);
        var produto = produtoRepository.getReferenceById(dados.idProduto());
        var pedido = new Pedido(criarCliente, produto, dados.quantidade(), dados.precoProduto(), dados.valorTotal());
        produtoService.retirarQuantidadeProduto(dados);
        pedidoRepository.save(pedido);
    }


}
