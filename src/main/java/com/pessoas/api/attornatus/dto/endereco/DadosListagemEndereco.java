package com.pessoas.api.attornatus.dto.endereco;

import com.pessoas.api.attornatus.endereco.Endereco;
import com.pessoas.api.attornatus.pessoa.Pessoa;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class DadosListagemEndereco{

    private String logradouro;
    private String cep;
    private String numero;
    private String cidade;
    private Pessoa pessoa;

    public DadosListagemEndereco(Endereco endereco) {
        this.logradouro = endereco.getLogradouro();
        this.cep = endereco.getCep();
        this.numero = endereco.getNumero();
        this.cidade = endereco.getCidade();
        this.pessoa = endereco.getPessoa();

    }

}
