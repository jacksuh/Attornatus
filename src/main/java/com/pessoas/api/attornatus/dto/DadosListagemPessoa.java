package com.pessoas.api.attornatus.dto;

import com.pessoas.api.attornatus.endereco.Endereco;
import com.pessoas.api.attornatus.pessoa.Pessoa;

public record DadosListagemPessoa(Long id, String nome) {

    public DadosListagemPessoa(Pessoa pessoa){

        this(pessoa.getId(), pessoa.getNome());
    }

}
