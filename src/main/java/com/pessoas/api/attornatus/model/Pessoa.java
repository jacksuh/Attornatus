package com.pessoas.api.attornatus.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.pessoas.api.attornatus.dto.pessoa.DadosAtualizarPessoa;
import com.pessoas.api.attornatus.dto.pessoa.DadosCadastroPessoa;
import com.pessoas.api.attornatus.dto.pessoa.DadosPessoa;
import com.pessoas.api.attornatus.model.Endereco;
import jakarta.persistence.*;
import lombok.*;
import java.time.LocalDate;
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

    @JsonFormat(pattern = "dd/MM/yyyy")
    private LocalDate dataNascimento;

    @JsonIgnore
    @OneToMany(mappedBy="pessoa")
    private List<Endereco> endereco;
    public Pessoa(DadosCadastroPessoa dados) {
        this.nome = dados.getNome();
        this.dataNascimento = dados.getDataNascimento();

    }

    public Pessoa(DadosPessoa pessoa) {
        this.id = pessoa.getId();
    }



    public void atualizarInformacoes(DadosAtualizarPessoa dados) {
        if(dados.getNome() != null){
            this.nome = dados.getNome();
        }
        if(dados.getDataNascimento() != null){
            this.dataNascimento = dados.getDataNascimento();
        }
    }


}
