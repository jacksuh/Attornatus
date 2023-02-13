package com.attornatus.api.pessoas.dto.pessoa;

import com.attornatus.api.pessoas.model.Pessoa;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


/**
 * Classe DadosPessoa - DTO - Data Transfer Object, responsavel por retornar id da pessoa.
 * Autor: Jackson Santos
 *
 */

@Getter
@Setter
@NoArgsConstructor
public class DadosPessoa{


    private Long id;

    public DadosPessoa(Pessoa pessoa){
        this.id = pessoa.getId();
    }
}
