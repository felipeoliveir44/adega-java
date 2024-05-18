package com.adega.api.controller;
import com.adega.api.domain.funcionario.Funcionario;
import com.adega.api.domain.funcionario.dto.DadosAtualizarFuncionario;
import com.adega.api.domain.funcionario.dto.DadosCadastrarFuncionario;
import com.adega.api.domain.funcionario.dto.DadosListagemFuncionario;
import com.adega.api.service.funcionario.FuncionarioService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/funcionario")
public class FuncionarioController {
    @Autowired
    private FuncionarioService service;
    @PostMapping("/cadastrar")
    @Transactional
    public ResponseEntity<DadosCadastrarFuncionario> cadastrar(@RequestBody @Valid DadosCadastrarFuncionario dados) {
        service.cadastrar(dados);
        return ResponseEntity.status(HttpStatus.CREATED).body(dados);
    }

    @GetMapping("/listar")
    public ResponseEntity<Page<DadosListagemFuncionario>> listarClientes(@PageableDefault(size = 10, sort = {"nome"}) Pageable paginacao) {
        var page = service.listarClientes(paginacao);
        return ResponseEntity.ok(page);
    }

    @PutMapping("/atualizar")
    @Transactional
    public ResponseEntity<DadosAtualizarFuncionario> atualizarCliente(@RequestBody DadosAtualizarFuncionario dadosCliente) {
        service.atualizarCliente(dadosCliente);
        return ResponseEntity.ok(dadosCliente);
    }

    @DeleteMapping("/desativar/{id}")
    @Transactional
    public ResponseEntity excluirCliente(@PathVariable Long id) {
        service.desativarFuncionario(id);
        return ResponseEntity.noContent().build();
    }

    @PutMapping("/ativar/{id}")
    @Transactional
    public ResponseEntity ativarCliente(@PathVariable Long id) {
        service.ativarFuncionario(id);
        return ResponseEntity.ok(id);
    }
}
