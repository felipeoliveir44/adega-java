package com.adega.api.service.gestao;

import com.adega.api.domain.gestao.GestaoFinancas;
import com.adega.api.domain.gestao.dto.*;
import com.adega.api.repository.GestaoFinaceiraRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;
@Service
public class GestaoFinancasService {
    @Autowired
    GestaoFinaceiraRepository repository;
    public void cadastro(DadosGestaoFinancas financas) {
        repository.save(new GestaoFinancas(financas));
    }

    public  RelatorioGestao  gestaoGeral(DadosListGanhoDispesa date) {
        if(date.date() != null && date.valor()!=null&& date.finacas() != null){
            return this.PesquisaMes(date.date(),date.valor(),date.finacas());
        }else if(date.date() != null&&date.finacas() != null){
           return this.RelatorioCategoriaData(date.date(),date.finacas());
        }else if(date.date() != null){
           return this.pesquisaPorDate(date.date());
        }else if(date.valor()!=null){
           return this.pesquisaPorValor(date.valor());
        }else if(date.finacas() != null){
            return this.pesquisaPorCategoria(date.finacas());
        }else {
            List<Transacoes> transacoes = repository.findAll().stream().map(Transacoes::new).toList();
            return new RelatorioGestao(transacoes,BigDecimal.ZERO);
        }
    }

    private RelatorioGestao RelatorioCategoriaData(LocalDate date, CategoriaFinacas finacas) {
        LocalDate date1 = AjusteDetempo.IncioDeAno(date);
        LocalDate date2 = AjusteDetempo.fimDeAno(date);
        BigDecimal valorTotal = repository.valorTotalCategoriaAno(finacas,date1,date2);
        List<Transacoes> transacoes= repository.findByFinacasAndDateBetween(finacas,date1,date2).stream().map(Transacoes::new).toList();
        return new RelatorioGestao(transacoes,valorTotal);
    }

    private RelatorioGestao PesquisaMes(LocalDate date, BigDecimal valor, CategoriaFinacas finacas) {
        LocalDate date1 = AjusteDetempo.inicioDeMes(date);
        LocalDate date2 = AjusteDetempo.fimDeMes(date);
        BigDecimal valorTotal = repository.valorTotalAno(finacas,valor,date1,date2);
        List<Transacoes> transacoes= repository.findByFinacasAndValorGreaterThanEqualAndDateBetween(finacas,valor,date1,date2).stream().map(Transacoes::new).toList();
        return new RelatorioGestao(transacoes,valorTotal);
    }

    private RelatorioGestao pesquisaPorCategoria(CategoriaFinacas finacas) {
        BigDecimal valorTotal = repository.valortotal(finacas);
        List<Transacoes> transacoes = repository.findByFinacas(finacas).stream().map(Transacoes::new).toList();
        return new RelatorioGestao(transacoes,valorTotal);
    }

    private RelatorioGestao pesquisaPorValor(BigDecimal valor) {
        List<Transacoes> transacoes = repository.findByValorGreaterThanEqual(valor).stream().map(Transacoes::new).toList();
        return new RelatorioGestao(transacoes,BigDecimal.ZERO);

    }

    private RelatorioGestao pesquisaPorDate(LocalDate date) {
        LocalDate date1 = AjusteDetempo.inicioDeMes(date);
        LocalDate date2 = AjusteDetempo.fimDeMes(date);
        List<Transacoes> transacoes = repository.findByDateBetween(date1,date2).stream().map(Transacoes::new).toList();
        return new RelatorioGestao(transacoes,BigDecimal.ZERO);
    }

    public RelatorioGestaoAno gestaAno(DadosListGanhoDispesa date) {
        if(date.date() != null && date.valor()!=null&& date.finacas() != null){
            return this.PesquisaPorTudo(date.date(),date.valor(),date.finacas());
        }else if(date.date() != null && date.valor()!=null){
            return this.PesquisaPorDataValor(date.date(),date.valor());
        }else if(date.date() != null&&date.finacas() != null){
            return this.PesquisaPorDataCategoria(date.date(),date.finacas());
        }else if(date.date() !=null){
            return this.PesquisaPorData(date.date());
        }else{
            return this.PesquisaGeralAno();
        }
    }

    private RelatorioGestaoAno PesquisaPorDataValor(LocalDate date, BigDecimal valor) {
        LocalDate date1 = AjusteDetempo.IncioDeAno(date);
        LocalDate date2 = AjusteDetempo.fimDeAno(date);
        List<Transacoes> transacoes= repository.findByDateBetweenAndValorGreaterThanEqual(date1,date2,valor).stream().map(Transacoes::new).toList();
        return new RelatorioGestaoAno(transacoes,null);
    }

    private RelatorioGestaoAno PesquisaPorDataCategoria(LocalDate date, CategoriaFinacas finacas) {
        LocalDate date1 = AjusteDetempo.IncioDeAno(date);
        LocalDate date2 = AjusteDetempo.fimDeAno(date);
        BigDecimal valorTotal = repository.valorTotalCategoriaAno(finacas,date1,date2);
        List<Transacoes> transacoes= repository.findByFinacasAndDateBetween(finacas,date1,date2).stream().map(Transacoes::new).toList();
        return new RelatorioGestaoAno(transacoes,valorTotal);
    }

    private RelatorioGestaoAno PesquisaPorData(LocalDate date) {
        LocalDate date1 = AjusteDetempo.IncioDeAno(date);
        LocalDate date2 = AjusteDetempo.fimDeAno(date);
        List<Transacoes> transacoes= repository.findByDateBetween(date1,date2).stream().map(Transacoes::new).toList();
        return new RelatorioGestaoAno(transacoes,null);

    }

    private RelatorioGestaoAno PesquisaGeralAno() {
        LocalDate date = LocalDate.now();
        LocalDate date1 = AjusteDetempo.IncioDeAno(date);
        LocalDate date2 = AjusteDetempo.fimDeAno(date);
        List<Transacoes> transacoes= repository.findByDateBetween(date1,date2).stream().map(Transacoes::new).toList();
        return new RelatorioGestaoAno(transacoes,null);

    }

    private RelatorioGestaoAno PesquisaPorTudo(LocalDate date, BigDecimal valor, CategoriaFinacas finacas) {
        LocalDate date1 = AjusteDetempo.IncioDeAno(date);
        LocalDate date2 = AjusteDetempo.fimDeAno(date);
        BigDecimal valorTotal = repository.valorTotalAno(finacas,valor,date1,date2);
        List<Transacoes> transacoes= repository.findByFinacasAndValorGreaterThanEqualAndDateBetween(finacas,valor,date1,date2).stream().map(Transacoes::new).toList();
        return new RelatorioGestaoAno(transacoes,valorTotal);
    }


}
