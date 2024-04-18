package com.adega.api.controller;

import com.adega.api.domain.categoria.dto.DadosCategoria;
import com.adega.api.domain.categoria.dto.DadosListaCategoria;
import com.adega.api.service.categoria.CategoriaService;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/categoria")
public class CategoriaController {
    @Autowired
    CategoriaService categoriaService;

    @PostMapping("/cadastra")
    @Transactional
    public ResponseEntity<DadosCategoria> cadastro (@RequestBody DadosCategoria categoria){
        return categoriaService.cadastra(categoria);

    }
    @GetMapping("/lista")
    public Page<DadosListaCategoria> lista(@PageableDefault(size = 10, sort = {"categoria"}) Pageable paginacao,@RequestBody DadosListaCategoria listaCategoria){
        return this.categoriaService.listar(paginacao,listaCategoria);

    }
}
