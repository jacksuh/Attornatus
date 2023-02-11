package com.pessoas.api.attornatus.dto.pessoa;

import com.pessoas.api.attornatus.endereco.Endereco;
import com.pessoas.api.attornatus.pessoa.Pessoa;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;
import java.util.Date;
import java.util.List;

@Getter
@Setter
public class DadosListagemPessoa {


    private Long id;
    private String nome;
    private LocalDate dataNascimento;
    private List<Endereco> endereco;

    public DadosListagemPessoa(Pessoa pessoa){

       this.id = pessoa.getId();
       this.nome = pessoa.getNome();
       this.dataNascimento = pessoa.getDataNascimento();
       this.endereco = pessoa.getEndereco();

    }

}
