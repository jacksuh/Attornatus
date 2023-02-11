package com.pessoas.api.attornatus.dto.pessoa;

import com.pessoas.api.attornatus.endereco.Endereco;
import com.pessoas.api.attornatus.pessoa.Pessoa;

import java.time.LocalDate;

public record DadosDetalhamentoPessoa (Long id, String nome, LocalDate dataNascimento){
    public DadosDetalhamentoPessoa (Pessoa pessoa) {
        this(pessoa.getId(), pessoa.getNome(), pessoa.getDataNascimento());
    }
}
