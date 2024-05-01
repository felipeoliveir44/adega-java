package com.adega.api.service.membro;

import com.adega.api.domain.funcionario.dto.DadosListagemFuncionario;
import com.adega.api.domain.membro.Membro;
import com.adega.api.domain.membro.dto.DadosCadastroMembro;
import com.adega.api.domain.membro.dto.DadosListagemMembro;
import com.adega.api.repository.MembroRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class MembroService {
    @Autowired
    private MembroRepository membroRepository;

    public void cadastrarMembro(DadosCadastroMembro dados) {
        var membro = new Membro(dados, dados.plano());
        membroRepository.save(membro);
    }

    public Page<DadosListagemMembro> listarMembros(Pageable paginacao) {
        return membroRepository.findAll(paginacao).map(DadosListagemMembro::new);
    }
}
