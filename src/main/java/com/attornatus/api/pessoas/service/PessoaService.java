package com.attornatus.api.pessoas.service;


import com.attornatus.api.pessoas.dto.pessoa.DadosAtualizarPessoa;
import com.attornatus.api.pessoas.dto.pessoa.DadosCadastroPessoa;
import com.attornatus.api.pessoas.dto.pessoa.DadosListagemPessoa;
import com.attornatus.api.pessoas.model.pessoa.Pessoa;
import com.attornatus.api.pessoas.repository.PessoaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.Optional;

/**
 * Classe para tratamento de dados e persistencia para o modelo Pessoa (regras de negocio).
 * Autor: Jackson Santos
 */

@Service
public class PessoaService {

    @Autowired
    private PessoaRepository repository;


    public Page<DadosListagemPessoa> listar(Pageable paginacao) {
        var page = repository.findAll(paginacao).map(DadosListagemPessoa::new);
        return page;
    }

    public Pessoa salvarPessoa(DadosCadastroPessoa dto) {
        Pessoa pessoa = new Pessoa();
        pessoa.setNome(dto.getNome());
        pessoa.setDataNascimento(dto.getDataNascimento());

        return repository.save(pessoa);
    }
    public Pessoa atualizarPessoa(DadosAtualizarPessoa dto) {
        Optional<Pessoa> optional = repository.findById(dto.getId());

        Pessoa p = new Pessoa();
        p.setId(dto.getId());
        p.setNome(dto.getNome());
        p.setDataNascimento(dto.getDataNascimento());
            return repository.save(p);
    }

    public void deletarPessoa(Long id){
        Optional<Pessoa> pessoa = repository.findById(id);
        if(pessoa.isPresent()){
            repository.deleteById(id);
        }
    }
}
