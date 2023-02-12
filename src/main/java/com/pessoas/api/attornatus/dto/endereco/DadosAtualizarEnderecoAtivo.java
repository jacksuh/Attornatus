package com.pessoas.api.attornatus.dto.endereco;

import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class DadosAtualizarEnderecoAtivo{

    @NotNull
    private Long id;
    private Boolean ativo;
}
