package com.pessoas.api.attornatus.dto;

import com.pessoas.api.attornatus.endereco.Endereco;
import com.pessoas.api.attornatus.pessoa.Pessoa;


public record DadosDetalhamentoEndereco(String logradouro, String cep, String numero, Pessoa pessoa) {
    public DadosDetalhamentoEndereco(Endereco endereco) {
        this (endereco.getLogradouro(), endereco.getCep(), endereco.getNumero(), endereco.getPessoa());
    }
}
