package com.pessoas.api.attornatus.dto.pessoa;

import java.time.LocalDate;

public record DadosAtualizarPessoa(
        Long id,
        String nome,

        LocalDate dataNascimento) {
}
