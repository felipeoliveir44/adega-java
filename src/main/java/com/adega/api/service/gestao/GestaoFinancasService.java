package com.adega.api.service.gestao;

import com.adega.api.domain.gestao.GestaoFinancas;
import com.adega.api.domain.gestao.dto.DadosGestaoFinancas;
import com.adega.api.repository.GestaoFinaceiraRepository;
import com.adega.api.domain.gestao.dto.RelatorioGestao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class GestaoFinancasService {
    @Autowired
    GestaoFinaceiraRepository repository;
    public void cadastro(DadosGestaoFinancas financas) {
        repository.save(new GestaoFinancas(financas));
    }

    public RelatorioGestao listGestao(){
        return null;
    }
}
