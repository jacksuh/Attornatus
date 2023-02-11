package com.pessoas.api.attornatus.dto.endereco;

import com.pessoas.api.attornatus.dto.pessoa.DadosPessoa;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@Getter
@Setter
@NoArgsConstructor
public class DadosCadastrarEndereco {

    private String logradouro;
    private String cep;
    private String numero;
    private String cidade;
    private DadosPessoa pessoa;

}
