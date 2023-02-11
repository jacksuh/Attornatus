package com.pessoas.api.attornatus.pessoa;

import com.pessoas.api.attornatus.dto.pessoa.DadosAtualizarPessoa;
import com.pessoas.api.attornatus.dto.pessoa.DadosCadastroPessoa;
import com.pessoas.api.attornatus.dto.pessoa.DadosDetalhamentoPessoa;
import org.junit.Assert;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;


import java.time.LocalDate;


@SpringBootTest
public class PessoaTest {

    @Autowired
    private PessoaRepository repository;

    @Test
    public void testeSalvar(){

        DadosCadastroPessoa p = new DadosCadastroPessoa();
        p.setNome("Jackson");
        p.setDataNascimento(LocalDate.of(1987, 7, 8));

        var pessoa = new Pessoa(p);
        repository.save(pessoa);

        Assert.assertEquals("Jackson", p.getNome());
        Assert.assertEquals(LocalDate.of(1987, 7, 8), p.getDataNascimento());
    }

    @Test
    public void testAtualizacaoFuncionario(){


        DadosCadastroPessoa p = new DadosCadastroPessoa();
        p.setNome("Jackson");
        p.setDataNascimento(LocalDate.of(1987, 7, 8));

        var pessoa = new Pessoa(p);
        repository.save(pessoa);

        Pessoa pessoas = new Pessoa(p);
        Long id = pessoas.getId();

        DadosAtualizarPessoa atualizar = new DadosAtualizarPessoa();
        atualizar.setId(id);
        atualizar.setNome("Jackson Santos");
        atualizar.setDataNascimento(LocalDate.of(1987, 7, 8));

        var atualizado = repository.getReferenceById(atualizar.getId());
        pessoa.atualizarInformacoes(atualizar);
        repository.save(atualizado);


        Assert.assertEquals("Jackson Santos", atualizado.getNome());
    }

    @Test
    public void testDeletarFuncionario(){

        DadosCadastroPessoa p = new DadosCadastroPessoa();
        p.setNome("Jackson");
        p.setDataNascimento(LocalDate.of(1987, 7, 8));

        var pessoa = new Pessoa(p);
        repository.save(pessoa);

        Pessoa pessoas = new Pessoa(p);
        Long id = pessoa.getId();

        repository.delete(pessoas);

    }



    @Test
    public void testePesquisarPessoa(){
        Page<Pessoa> p = repository.findAll(PageRequest.of(0,1));

        Assert.assertEquals(1, p.getSize());
    }


}
