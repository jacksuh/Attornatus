package com.attornatus.api.pessoas.dto.pessoa;

import com.attornatus.api.pessoas.model.Pessoa;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
public class DadosDetalhamentoPessoa{

    private Long id;
    private String nome;
    private LocalDate dataNascimento;

    public DadosDetalhamentoPessoa (Pessoa pessoa) {
        this.id = pessoa.getId();
        this.nome = pessoa.getNome();
        this.dataNascimento = pessoa.getDataNascimento();
    }
}