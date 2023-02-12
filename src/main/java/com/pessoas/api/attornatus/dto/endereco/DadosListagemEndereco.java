package com.pessoas.api.attornatus.dto.endereco;

import com.pessoas.api.attornatus.model.Endereco;
import com.pessoas.api.attornatus.model.Pessoa;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class DadosListagemEndereco{

    private Long id;

    private String logradouro;
    private String cep;
    private String numero;
    private String cidade;
    private Pessoa pessoa;

    private boolean ativo;

    public DadosListagemEndereco(Endereco endereco) {
        this.id = endereco.getId();
        this.logradouro = endereco.getLogradouro();
        this.cep = endereco.getCep();
        this.numero = endereco.getNumero();
        this.cidade = endereco.getCidade();
        this.pessoa = endereco.getPessoa();
        this.ativo = endereco.isAtivo();

    }

}
