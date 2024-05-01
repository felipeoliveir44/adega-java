package com.adega.api.service.funcionario;

import com.adega.api.domain.funcionario.Funcionario;
import com.adega.api.domain.funcionario.dto.DadosAtualizarFuncionario;
import com.adega.api.domain.funcionario.dto.DadosCadastrarFuncionario;
import com.adega.api.domain.funcionario.dto.DadosListagemFuncionario;
import com.adega.api.repository.FuncionarioRepository;
import org.apache.coyote.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

@Service
public class FuncionarioService {
    @Autowired
    private FuncionarioRepository repository;

    public void cadastrar(DadosCadastrarFuncionario dados) {
        var funcionario = new Funcionario(dados);
        repository.save(funcionario);
    }

    public Page<DadosListagemFuncionario> listarClientes(Pageable paginacao) {
        return repository.findAll(paginacao).map(DadosListagemFuncionario::new);
    }

    public void atualizarCliente(DadosAtualizarFuncionario dados) {
        var funcionario = repository.getReferenceById(dados.id());
        funcionario.atualizarInformacoes(dados);
    }

    public void desativarFuncionario(Long id) {
        var funcionario = repository.getReferenceById(id);
        funcionario.desativaFuncionario();
    }

    public void ativarFuncionario(Long id) {
        var funcionario = repository.getReferenceById(id);
        funcionario.ativarFuncionario();
    }

}
