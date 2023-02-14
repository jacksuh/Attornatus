package com.attornatus.api.pessoas.dto.endereco;

import com.attornatus.api.pessoas.model.endereco.Endereco;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * Classe DadosDetalhamentoEndereco - DTO - Data Transfer Object, responsavel para devolver detalhado o endereço.
 * Autor: Jackson Santos
 *
 */


@Getter
@Setter
@NoArgsConstructor
public class DadosDetalhamentoEndereco{

    private String logradouro;
    private String cep;
    private String numero;
    private String cidade;
    private Long pessoa;

    private boolean ativo;

    public DadosDetalhamentoEndereco(Endereco endereco) {
        this.logradouro = endereco.getLogradouro();
        this.cep = endereco.getCep();
        this.numero = endereco.getNumero();
        this.cidade = endereco.getCidade();
        this.pessoa = endereco.getPessoa().getId();
        this.ativo = endereco.isAtivo();

    }

}
