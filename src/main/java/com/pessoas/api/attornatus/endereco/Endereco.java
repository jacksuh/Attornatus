package com.pessoas.api.attornatus.endereco;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.pessoas.api.attornatus.dto.endereco.DadosAtualizarEnderecoAtivo;
import com.pessoas.api.attornatus.dto.endereco.DadosCadastrarEndereco;
import com.pessoas.api.attornatus.pessoa.Pessoa;
import jakarta.persistence.*;
import lombok.*;

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
        this.logradouro = dados.logradouro();
        this.cep = dados.cep();
        this.numero = dados.numero();
        this.pessoa = new Pessoa(dados.pessoa());
    }

    public void excluir() {
        this.ativo = false;
    }

    public void atualizarInformacoes(DadosAtualizarEnderecoAtivo dados) {
            if (dados.ativo() != null){
                this.ativo = dados.ativo();
            }
    }
}
