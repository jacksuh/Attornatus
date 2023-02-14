package com.attornatus.api.pessoas.dto.pessoa;

import com.attornatus.api.pessoas.model.pessoa.Pessoa;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

/**
 * Classe DadosDetalhamentoPessoa - DTO - Data Transfer Object, responsavel por retornar dados da pessoa.
 * Autor: Jackson Santos
 *
 */

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
