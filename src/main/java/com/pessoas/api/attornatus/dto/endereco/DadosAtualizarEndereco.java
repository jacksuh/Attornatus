package com.pessoas.api.attornatus.dto.endereco;

import com.pessoas.api.attornatus.dto.pessoa.DadosPessoa;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class DadosAtualizarEndereco {

    @NotNull
    private Long id;
    private String logradouro;
    private String cep;
    private String numero;
    private String cidade;

    @NotNull
    private DadosPessoa pessoa;
    private boolean ativo;
}
