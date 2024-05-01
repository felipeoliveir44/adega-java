package com.adega.api.controller;


import com.adega.api.domain.funcionario.dto.DadosListagemFuncionario;
import com.adega.api.domain.membro.dto.DadosCadastroMembro;
import com.adega.api.domain.membro.dto.DadosListagemMembro;
import com.adega.api.service.membro.MembroService;
import jakarta.validation.Valid;
import org.apache.coyote.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/membro")
public class MembroController {

    @Autowired
    private MembroService service;

    @PostMapping("/cadastrar")
    @Transactional
    public ResponseEntity<DadosCadastroMembro> cadastrar(@RequestBody @Valid DadosCadastroMembro dados) {
        service.cadastrarMembro(dados);
        return ResponseEntity.status(HttpStatus.CREATED).body(dados);
    }

    @GetMapping("/listar")
    public ResponseEntity<Page<DadosListagemMembro>> listarMembros(@PageableDefault(size = 10, sort = {"nome"}) Pageable paginacao) {
        var page = service.listarMembros(paginacao);
        return ResponseEntity.ok(page);
    }


}
