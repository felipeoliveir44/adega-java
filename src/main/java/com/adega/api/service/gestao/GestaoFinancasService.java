package com.adega.api.service.gestao;

import com.adega.api.domain.gestao.GestaoFinancas;
import com.adega.api.domain.gestao.dto.*;
import com.adega.api.repository.GestaoFinaceiraRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class GestaoFinancasService {
    @Autowired
    GestaoFinaceiraRepository repository;
    public void cadastro(DadosGestaoFinancas financas) {
        repository.save(new GestaoFinancas(financas));
    }

    public  List<Transacoes>  gestaoGeral(DadosListGanhoDispesa date) {
        if(date.date() != null){
            LocalDate date1 = AjusteDetempo.inicioDeMes(date.date());
            LocalDate date2 = AjusteDetempo.fimDeMes(date.date());
            System.out.println(date1 + "      "+ date2);
            return repository.findByDateBetween(date1,date2).stream().map(Transacoes::new).toList();
        }else if(date.valor()!=null){
           return repository.findByValorGreaterThanEqual(date.valor()).stream().map(Transacoes::new).toList();
        }else if(date.finacas() != null){
            return repository.findByFinacas(date.finacas()).stream().map(Transacoes::new).toList();
        }else {
           return repository.findAll().stream().map(Transacoes::new).toList();
        }


    }
/*
    public List<Transacoes> gestaAno(DadosListGanhoDispesa date) {
        if(date.date() != null && date.valor()!=null){
            LocalDate date1 = AjusteDetempo.IncioDeAno(date.date());
            LocalDate date2 = AjusteDetempo.fimDeAno(date.date());
            return repository.findByValorGreaterThanEqualAndDateBetween(date.valor(),date1,date2).stream().map(Transacoes::new).toList();
        }else if(date.date()!=null){
            LocalDate date1 = AjusteDetempo.IncioDeAno(date.date());
            LocalDate date2 = AjusteDetempo.fimDeAno(date.date());
            System.out.println(date1 + "      "+ date2);
            return repository.findByDateBetween(date1,date2).stream().map(Transacoes::new).toList();
        }else if(date.finacas() != null){
            return repository.findByFinacas(date.finacas()).stream().map(Transacoes::new).toList();
        }else {
            LocalDate date1 = AjusteDetempo.IncioDeAno(LocalDate.now());
            LocalDate date2 = AjusteDetempo.fimDeAno(LocalDate.now());
            return repository.findByDateBetween(date1,date2).stream().map(Transacoes::new).toList();
        }
    }

 */
}
