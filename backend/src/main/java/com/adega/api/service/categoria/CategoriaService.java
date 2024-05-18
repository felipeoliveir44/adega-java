package com.adega.api.service.categoria;

import com.adega.api.domain.categoria.Categoria;
import com.adega.api.domain.categoria.dto.DadosCategoria;
import com.adega.api.domain.categoria.dto.DadosListaCategoria;
import com.adega.api.repository.CategoriaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public class CategoriaService {
    @Autowired
    CategoriaRepository categoriaRepository;

    public ResponseEntity<DadosCategoria> cadastra(DadosCategoria categoria) {
        categoriaRepository.save(new Categoria(categoria));
        return ResponseEntity.ok().body(categoria);
    }

    public Page<DadosListaCategoria> listar(Pageable paginacao, DadosListaCategoria listaCategoria) {

        if(listaCategoria.id()!=null && listaCategoria.id()>0 ){
            return categoriaRepository.findById(listaCategoria.id(),paginacao).map(DadosListaCategoria::new);
        }else if(listaCategoria.nome()!=null && listaCategoria.nome().length()>2 ){
            return categoriaRepository.findByCategoria(listaCategoria.nome(),paginacao).map(DadosListaCategoria::new);
        }else {
            return categoriaRepository.findAll(paginacao).map(DadosListaCategoria::new);
        }
    }
}
