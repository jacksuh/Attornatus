package com.pessoas.api.attornatus.dto.endereco;

import com.pessoas.api.attornatus.endereco.Endereco;
import com.pessoas.api.attornatus.pessoa.Pessoa;


public record DadosListagemEndereco(String logradouro, String cep, String numero, String cidade, Pessoa pessoa) {

    public DadosListagemEndereco(Endereco endereco){
        this(endereco.getLogradouro(), endereco.getCep(), endereco.getNumero(), endereco.getCidade(), endereco.getPessoa());

    }
}
