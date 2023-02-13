package com.attornatus.api.pessoas.dto.endereco;

import com.attornatus.api.pessoas.dto.pessoa.DadosPessoa;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;

/**
 * Classe DadosAtualizarEndereco - DTO - Data Transfer Object, responsavel pelo tratamento de dados passados para atualização de dados.
 * Autor: Jackson Santos
 *
 */

@Getter
@Setter
public class DadosAtualizarEndereco {

    @NotNull
    private Long id;
    private String logradouro;
    private String cep;
    private String numero;
    private String cidade;
    private boolean ativo;
    @NotNull
    private DadosPessoa pessoa;
}
