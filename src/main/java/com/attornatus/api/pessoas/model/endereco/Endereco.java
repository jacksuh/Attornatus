package com.attornatus.api.pessoas.model.endereco;

import com.attornatus.api.pessoas.dto.endereco.DadosAtualizarEndereco;
import com.attornatus.api.pessoas.dto.endereco.DadosCadastrarEndereco;
import com.attornatus.api.pessoas.model.pessoa.Pessoa;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.*;

/**
 * Classe para declaração de dados e persistencia com o banco de dados, sera criado a tabela Endereco.
 * Tratamento de cardinalidade N-1 com a classe pessoa.
 * Atributo boolean para ativar endereço principal.
 *
 * Autor: Jackson Santos
 */


@Table(name = "endereco")
@Entity(name = "Endereco")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = "id")
public class Endereco {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String logradouro;
    private String cep;
    private String numero;

    private String cidade;

    @JsonIgnore
   @ManyToOne
   @JoinColumn(name="pessoa_id", referencedColumnName="id",nullable=false)
   private Pessoa pessoa;

    private boolean ativo;

    public Endereco(DadosCadastrarEndereco dados) {
        this.logradouro = dados.getLogradouro();
        this.cep = dados.getCep();
        this.numero = dados.getNumero();
        this.cidade = dados.getCidade();
        this.pessoa = new Pessoa(dados.getPessoa());
    }

    public void excluir() {
        this.ativo = false;
    }

    //public void atualizarInformacoes(DadosAtualizarEnderecoAtivo dados) {
           // if (dados.getAtivo() != null){
             //   this.ativo = dados.getAtivo();
         //   }
 //   }


    public void atualizarInformacoes(DadosAtualizarEndereco dados) {
        if(dados.getLogradouro() != null){
            this.logradouro = dados.getLogradouro();
        }
        if(dados.getCep() != null){
            this.cep = dados.getCep();
        }
        if(dados.getNumero() != null){
            this.numero = dados.getNumero();
        }
        if(dados.getCidade() != null){
            this.cidade = dados.getCidade();
        }
        if(dados.getPessoa() != null){
            this.pessoa = new Pessoa(dados.getPessoa());
        }
    }
}
