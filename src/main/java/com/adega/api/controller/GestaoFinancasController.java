package com.adega.api.controller;

import com.adega.api.domain.gestao.dto.*;
import com.adega.api.service.gestao.GestaoFinancasService;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

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
    public List<Transacoes> listDispesaGanho(@RequestBody DadosListGanhoDispesa date){
        return service.gestaoGeral(date);
    }
 /*
    @GetMapping("/ano")
    public List<Transacoes> listDispesaGanhoAno(@RequestBody DadosListGanhoDispesa date){
        return service.gestaAno(date);
    }



    @GetMapping("/month")
    public List<CategoryMonth> listDispesaGanhoMes(@RequestBody DadosListGanhoDispesa date){
        return service.ManagementListMonth(dataManagementList);
    }

     */


}
