package com.adega.api.controller;

import com.adega.api.domain.gestao.dto.DadosGestaoFinancas;
import com.adega.api.service.gestao.GestaoFinancasService;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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



}
