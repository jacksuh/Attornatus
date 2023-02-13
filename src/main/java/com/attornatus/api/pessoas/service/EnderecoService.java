package com.attornatus.api.pessoas.service;

import com.attornatus.api.pessoas.dto.endereco.DadosAtualizarEndereco;
import com.attornatus.api.pessoas.dto.endereco.DadosCadastrarEndereco;
import com.attornatus.api.pessoas.dto.endereco.DadosListagemEndereco;
import com.attornatus.api.pessoas.model.Pessoa;
import com.attornatus.api.pessoas.repository.EnderecoRepository;
import com.attornatus.api.pessoas.repository.PessoaRepository;
import com.attornatus.api.pessoas.model.Endereco;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.Optional;

/**
 * Classe para tratamento de dados e persistencia para o modelo Endereco (regras de negocio).
 * Autor: Jackson Santos
 */


@Service
public class EnderecoService {

    @Autowired
    private EnderecoRepository repository;

    @Autowired
    private PessoaRepository pessoaRepository;


    public Page<DadosListagemEndereco> listar(Pageable paginacao) {
        var page = repository.findAll(paginacao).map(DadosListagemEndereco::new);
        return page;
    }

    public Endereco salvarEndereco(DadosCadastrarEndereco dto) {
        Long idDescricao = dto.getPessoa().getId();
        Pessoa pessoa =
                pessoaRepository.findById(idDescricao)
                        .orElseThrow(()-> new ResponseStatusException(HttpStatus.BAD_REQUEST, "Pessoa não encontrada"));

        Endereco endereco = new Endereco();
        endereco.setLogradouro(dto.getLogradouro());
        endereco.setCep(dto.getCep());
        endereco.setNumero(dto.getNumero());
        endereco.setCidade(dto.getCidade());
        endereco.setPessoa(pessoa);

        return repository.save(endereco);
    }


    public Endereco atualizarEndereco(DadosAtualizarEndereco dto) {
        Long idDescricao = dto.getPessoa().getId();
        Pessoa pessoa =
                pessoaRepository.findById(idDescricao)
                        .orElseThrow(()-> new ResponseStatusException(HttpStatus.BAD_REQUEST, "Pessoa não encontrada"));


        Endereco e = new Endereco();
        e.setId(dto.getId());
        e.setLogradouro(dto.getLogradouro());
        e.setCep(dto.getCep());
        e.setNumero(dto.getNumero());
        e.setCidade(dto.getCidade());
        e.setAtivo(dto.isAtivo());
        e.setPessoa(pessoa);

        return repository.save(e);
    }



    public void deletarEndereco(Long id){
        Optional<Endereco> endereco = repository.findById(id);
        if(endereco.isPresent()){
            repository.deleteById(id);
        }
    }

}

