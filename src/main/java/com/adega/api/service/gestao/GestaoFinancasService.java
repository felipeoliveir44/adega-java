package com.adega.api.service.gestao;

import com.adega.api.domain.gestao.GestaoFinancas;
import com.adega.api.domain.gestao.dto.*;
import com.adega.api.repository.GestaoFinaceiraRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class GestaoFinancasService {
    @Autowired
    GestaoFinaceiraRepository repository;
    public void cadastro(DadosGestaoFinancas financas) {
        repository.save(new GestaoFinancas(financas));
    }


    public <T> T listGestao(DadosGestao infos) {
        List<Transacoes> transacoes = repository.findAll().stream().map(Transacoes::new).toList();
        //return (T) new RelatorioGestao(transacoes, repository.DESPESA(), repository.RECEITA());
        if(CategoriaFinacas.RECEITA.equals(infos.finacas())){
            return (T)  repository.RECEITA();
        }else if(CategoriaFinacas.DESPESA.equals(infos.finacas())){
            return (T)  repository.DESPESA();
        }else{
            return (T) new RelatorioGestao(transacoes, repository.DESPESA(), repository.RECEITA());
        }

      

    }
}
