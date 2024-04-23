package com.adega.api.controller;

import com.adega.api.domain.gestao.dto.CategoriaFinacas;
import com.adega.api.domain.gestao.dto.DadosGestao;
import com.adega.api.domain.gestao.dto.DadosGestaoFinancas;
import com.adega.api.domain.gestao.dto.RelatorioGestao;
import com.adega.api.service.gestao.GestaoFinancasService;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/gestao")
public class GestaoFinancasController {
    @Autowired
    GestaoFinancasService service;

    @PostMapping("/cadastra")
    @Transactional
    public void cadastro(@RequestBody DadosGestaoFinancas financas){
        System.out.println(financas);
        service.cadastro(financas);
    }
    @GetMapping
    public <T> T listReceitas(@RequestBody DadosGestao infos){
        return service.listGestao(infos);
    }



}
