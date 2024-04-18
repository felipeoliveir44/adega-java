package com.adega.api.service.fornecedor;

import com.adega.api.domain.categoria.dto.DadosListaCategoria;
import com.adega.api.domain.fornecedor.Fornecedor;
import com.adega.api.domain.fornecedor.dto.DadosFornecedorAtualizar;
import com.adega.api.domain.fornecedor.dto.DadosFornecedorCadastro;
import com.adega.api.domain.fornecedor.dto.DadosList;
import com.adega.api.domain.fornecedor.dto.DadosListFornecedor;
import com.adega.api.repository.FornecedorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class FornecedorService {
    @Autowired
    FornecedorRepository fornecedorRepository;

    public ResponseEntity<DadosFornecedorCadastro> cadastraFornecedor(DadosFornecedorCadastro dados) {
        fornecedorRepository.save(new Fornecedor(dados));
        return ResponseEntity.ok().body(dados);
    }

    public ResponseEntity<DadosFornecedorAtualizar> atualizarForncedor(Long id, DadosFornecedorAtualizar atualizar) {
        Optional<Fornecedor> optional  = fornecedorRepository.findById(id);
        if(optional.isEmpty()){
            throw new RuntimeException("FORNECEDOR NÃO ENCONTRADO");
        }else{
            optional.ifPresent(f->f.atualizarInfos(atualizar));
            return ResponseEntity.ok().body(atualizar);

        }


    }

    public Page<Fornecedor> listForncedor(Pageable paginacao, DadosList dadosList) {
        if(dadosList.id() != null && dadosList.id()>0 ){
            return fornecedorRepository.findById(dadosList.id(),paginacao);
        }else if(dadosList.nome()!=null && dadosList.nome().length()>2 ){
            return fornecedorRepository.findByNomeContaining(dadosList.nome(),paginacao);
        }else {
            return fornecedorRepository.findAll(paginacao);
        }
    }
}
