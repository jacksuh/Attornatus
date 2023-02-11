package com.pessoas.api.attornatus.dto.pessoa;


import java.time.LocalDate;

public record DadosCadastroPessoa(
        String nome,


        LocalDate dataNascimento) {
}
