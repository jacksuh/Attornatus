package com.attornatus.api.pessoas.dto.endereco;

import com.attornatus.api.pessoas.model.Endereco;
import com.attornatus.api.pessoas.model.Pessoa;
import lombok.Getter;
import lombok.Setter;

/**
 * Classe DadosListagemEndereco - DTO - Data Transfer Object, responsavel para devolver Lista de endereço.
 * Autor: Jackson Santos
 *
 */

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
