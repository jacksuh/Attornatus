package com.pessoas.api.attornatus.dto.pessoa;

import com.pessoas.api.attornatus.endereco.Endereco;
import com.pessoas.api.attornatus.pessoa.Pessoa;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;
import java.util.Date;

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
