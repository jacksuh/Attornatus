package com.pessoas.api.attornatus.dto.endereco;

import com.pessoas.api.attornatus.endereco.Endereco;
import com.pessoas.api.attornatus.pessoa.Pessoa;


public record DadosDetalhamentoEndereco(String logradouro, String cep, String numero, String cidade, Long Pessoa) {
    public DadosDetalhamentoEndereco(Endereco endereco) {
        this (endereco.getLogradouro(), endereco.getCep(), endereco.getNumero(), endereco.getCidade(), endereco.getPessoa().getId());
    }
}
