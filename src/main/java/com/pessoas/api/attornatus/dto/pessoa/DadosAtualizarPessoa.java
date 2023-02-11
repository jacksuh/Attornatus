package com.pessoas.api.attornatus.dto.pessoa;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
@NoArgsConstructor
public class DadosAtualizarPessoa {

    private Long id;
    private String nome;
    private LocalDate dataNascimento;
}
