package com.adega.api.service.membro;

import com.adega.api.domain.membro.Membro;
import com.adega.api.domain.membro.dto.DadosCadastroMembro;
import com.adega.api.domain.membro.dto.DadosListagemMembro;
import com.adega.api.domain.produto.dto.DadosListagemProdutosAleatorios;
import com.adega.api.repository.MembroRepository;
import com.adega.api.service.produto.ProdutoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MembroService {
    @Autowired
    private MembroRepository membroRepository;

    @Autowired
    private ProdutoService produtoService;

    public void cadastrarMembro(DadosCadastroMembro dados) {
        var membro = new Membro(dados, dados.plano());
        membroRepository.save(membro);
    }

    public Page<DadosListagemMembro> listarMembros(Pageable paginacao) {
        return membroRepository.findAll(paginacao).map(DadosListagemMembro::new);
    }

    public List<DadosListagemProdutosAleatorios> listarProdutos() {
       return produtoService.retornarItemsComDesconto();
    }
}
