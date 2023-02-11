package com.pessoas.api.attornatus.endereco;

import com.pessoas.api.attornatus.dto.endereco.DadosCadastrarEndereco;
import com.pessoas.api.attornatus.dto.pessoa.DadosCadastroPessoa;
import com.pessoas.api.attornatus.dto.pessoa.DadosPessoa;
import com.pessoas.api.attornatus.pessoa.Pessoa;
import com.pessoas.api.attornatus.pessoa.PessoaRepository;
import org.junit.Assert;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;

import java.time.LocalDate;


@SpringBootTest
public class EnderecoTest {

    @Autowired
    private EnderecoRepository repository;

    @Autowired
    private PessoaRepository pessoaRepository;

    @Test
    public void testeSalvar(){

        DadosCadastroPessoa pessoa = new DadosCadastroPessoa();
        pessoa.setNome("Jackson");
        pessoa.setDataNascimento(LocalDate.of(1987, 7, 8));

        var p = new Pessoa(pessoa);
        pessoaRepository.save(p);

        Pessoa pessoas = new Pessoa(pessoa);
        Long id = pessoas.getId();

        Assert.assertEquals("Jackson",pessoas.getNome());

        DadosCadastrarEndereco e = new DadosCadastrarEndereco();
        e.setLogradouro("rua 1");
        e.setCep("12345678");
        e.setNumero("5");
        e.setCidade("São Paulo");
        e.setPessoa();

        var endereco = new Endereco(e);
        repository.save(endereco);

        Assert.assertEquals("rua 1", e.getLogradouro());


    }


    @Test
    public void testDeletarFuncionario(){

        DadosCadastrarEndereco e = new DadosCadastrarEndereco();
        e.setLogradouro("rua 1");
        e.setCep("12345678");
        e.setNumero("5");
        e.setCidade("São Paulo");

        var endereco = new Endereco(e);
        repository.save(endereco);

        Endereco end = new Endereco(e);
        Long id = endereco.getId();

        repository.delete(end);

    }

    @Test
    public void testePesquisarPessoa(){
        Page<Endereco> p = repository.findAll(PageRequest.of(0,1));

        Assert.assertEquals(1, p.getSize());
    }
}
