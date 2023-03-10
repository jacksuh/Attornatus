package com.attornatus.api.pessoas.dto.pessoa;


import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;

/**
 * Classe DadosCadastroPessoa - DTO - Data Transfer Object, responsavel por Salvar dados da pessoa.
 * Autor: Jackson Santos
 *
 */


@Getter
@Setter
@NoArgsConstructor
public class  DadosCadastroPessoa {

        private Long id;

        private  String nome;

        @JsonFormat(pattern = "dd/MM/yyyy")
        private LocalDate dataNascimento;


}
