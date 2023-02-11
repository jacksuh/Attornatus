package com.pessoas.api.attornatus.dto;

import com.pessoas.api.attornatus.pessoa.Pessoa;

public record DadosPessoa(Long id) {

    public DadosPessoa(Pessoa pessoa){
        this(pessoa.getId());
    }
}
