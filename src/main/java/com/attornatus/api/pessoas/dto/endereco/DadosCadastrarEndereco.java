package com.attornatus.api.pessoas.dto.endereco;

import com.attornatus.api.pessoas.dto.pessoa.DadosPessoa;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@Getter
@Setter
@NoArgsConstructor
public class DadosCadastrarEndereco {

    @NotBlank
    private String logradouro;
    @NotBlank
    private String cep;
    @NotBlank
    private String numero;
    @NotBlank
    private String cidade;
    @NotNull
    private DadosPessoa pessoa;

}
