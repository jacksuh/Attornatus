package com.pessoas.api.attornatus.dto.pessoa;

import com.pessoas.api.attornatus.pessoa.Pessoa;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class DadosPessoa{


    private Long id;

    public DadosPessoa(Pessoa pessoa){
        this.id = pessoa.getId();
    }
}
