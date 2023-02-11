package com.pessoas.api.attornatus.endereco;

import com.pessoas.api.attornatus.dto.DadosAtualizarPessoa;
import com.pessoas.api.attornatus.dto.DadosCadastrarEndereco;
import com.pessoas.api.attornatus.pessoa.Pessoa;
import jakarta.persistence.*;
import lombok.*;

import java.util.List;

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

   @ManyToOne
   private Pessoa pessoa;


    public Endereco(DadosCadastrarEndereco dados) {
        this.logradouro = dados.logradouro();
        this.cep = dados.cep();
        this.numero = dados.numero();
        this.pessoa = new Pessoa(dados.pessoa());
    }
}
