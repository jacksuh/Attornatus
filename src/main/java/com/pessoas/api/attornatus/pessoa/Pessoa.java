package com.pessoas.api.attornatus.pessoa;

import com.pessoas.api.attornatus.dto.DadosAtualizarPessoa;
import com.pessoas.api.attornatus.dto.DadosCadastrarEndereco;
import com.pessoas.api.attornatus.dto.DadosCadastroPessoa;
import com.pessoas.api.attornatus.dto.DadosPessoa;
import com.pessoas.api.attornatus.endereco.Endereco;
import jakarta.persistence.*;
import lombok.*;

import java.util.List;


@Table(name = "pessoas")
@Entity(name = "Pessoas")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = "id")
public class Pessoa {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nome;


    public Pessoa(DadosCadastroPessoa dados) {
        this.nome = dados.nome();

    }

    public Pessoa(DadosPessoa pessoa) {
        this.id = pessoa.id();
    }


    public void atualizarInformacoes(DadosAtualizarPessoa dados) {
        if(dados.nome() != null){
            this.nome = dados.nome();
        }
    }


}
