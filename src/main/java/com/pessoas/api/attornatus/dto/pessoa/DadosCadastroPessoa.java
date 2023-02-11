package com.pessoas.api.attornatus.dto.pessoa;


import com.fasterxml.jackson.annotation.JsonFormat;
import com.pessoas.api.attornatus.dto.endereco.DadosCadastrarEndereco;
import com.pessoas.api.attornatus.endereco.Endereco;
import com.pessoas.api.attornatus.pessoa.Pessoa;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.modelmapper.ModelMapper;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDate;
import java.util.Date;

@Getter
@Setter
@NoArgsConstructor
public class  DadosCadastroPessoa {

        private  String nome;

        @JsonFormat(pattern = "dd/MM/yyyy")
        private LocalDate dataNascimento;


}
