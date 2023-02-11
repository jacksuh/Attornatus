package com.pessoas.api.attornatus.dto.endereco;

import com.pessoas.api.attornatus.dto.pessoa.DadosPessoa;

public record DadosCadastrarEndereco (String logradouro, String cep, String numero, String cidade, DadosPessoa pessoa) {
}
