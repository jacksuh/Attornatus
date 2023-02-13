package com.attornatus.api.pessoas.dto.pessoa;

import com.attornatus.api.pessoas.model.Pessoa;
import com.attornatus.api.pessoas.model.Endereco;
import lombok.Getter;
import lombok.Setter;
import java.time.LocalDate;
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
