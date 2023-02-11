package com.pessoas.api.attornatus.dto.pessoa;

import com.pessoas.api.attornatus.endereco.Endereco;
import com.pessoas.api.attornatus.pessoa.Pessoa;

import java.time.LocalDate;
import java.util.List;

public record DadosListagemPessoa(Long id, String nome, LocalDate dataNascimento, List<Endereco> endereco) {


    public DadosListagemPessoa(Pessoa pessoa){

        this(pessoa.getId(), pessoa.getNome(), pessoa.getDataNascimento(), pessoa.getEndereco());

    }

}
