package com.attornatus.api.pessoas.dto.pessoa;

import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;

/**
 * Classe DadosAtualizarPessoa - DTO - Data Transfer Object, responsavel por atualizar dados da pessoa.
 * Autor: Jackson Santos
 *
 */

@Getter
@Setter
@NoArgsConstructor
public class DadosAtualizarPessoa {

    @NotNull
    private Long id;
    private String nome;
    @JsonFormat(pattern = "dd/MM/yyyy")
    private LocalDate dataNascimento;
}
