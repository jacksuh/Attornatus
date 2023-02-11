package com.pessoas.api.attornatus.dto;

import com.pessoas.api.attornatus.endereco.Endereco;
import com.pessoas.api.attornatus.pessoa.Pessoa;

public record DadosDetalhamentoPessoa (Long id, String nome){
    public DadosDetalhamentoPessoa (Pessoa pessoa) {
        this(pessoa.getId(), pessoa.getNome());
    }
}
