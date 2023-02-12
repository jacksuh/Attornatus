package com.pessoas.api.attornatus.service;


import com.pessoas.api.attornatus.dto.pessoa.DadosAtualizarPessoa;
import com.pessoas.api.attornatus.dto.pessoa.DadosCadastroPessoa;
import com.pessoas.api.attornatus.dto.pessoa.DadosListagemPessoa;
import com.pessoas.api.attornatus.model.Pessoa;
import com.pessoas.api.attornatus.repository.PessoaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.Optional;

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
