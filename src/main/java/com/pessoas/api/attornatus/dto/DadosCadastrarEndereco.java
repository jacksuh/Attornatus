package com.pessoas.api.attornatus.dto;

import com.pessoas.api.attornatus.pessoa.Pessoa;

public record DadosCadastrarEndereco (String logradouro, String cep, String numero, DadosPessoa pessoa) {
}
