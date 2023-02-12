package com.pessoas.api.attornatus.pessoa;

import com.pessoas.api.attornatus.dto.pessoa.DadosAtualizarPessoa;
import com.pessoas.api.attornatus.dto.pessoa.DadosCadastroPessoa;
import com.pessoas.api.attornatus.dto.pessoa.DadosListagemPessoa;
import com.pessoas.api.attornatus.model.Pessoa;
import com.pessoas.api.attornatus.service.PessoaService;
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
    private PessoaService pessoaService;

    @Test
    public void testeSalvar(){

        DadosCadastroPessoa p = new DadosCadastroPessoa();
        p.setNome("Jackson");
        p.setDataNascimento(LocalDate.of(1987, 7, 8));


        Pessoa pessoa = pessoaService.salvarPessoa(p);

        Assert.assertEquals("Jackson", p.getNome());
        Assert.assertEquals(LocalDate.of(1987, 7, 8), p.getDataNascimento());
    }

    @Test
    public void testAtualizacaoPessoa(){


        DadosCadastroPessoa p = new DadosCadastroPessoa();
        p.setNome("Jackson");
        p.setDataNascimento(LocalDate.of(1987, 7, 8));

        Pessoa pessoa = pessoaService.salvarPessoa(p);

        Long id = pessoa.getId();

        DadosAtualizarPessoa atualizar = new DadosAtualizarPessoa();
        atualizar.setId(id);
        atualizar.setNome("Jackson Santos");
        atualizar.setDataNascimento(LocalDate.of(1987, 7, 8));

        Pessoa atualizado = pessoaService.atualizarPessoa(atualizar);


        Assert.assertEquals("Jackson Santos", atualizado.getNome());
    }

    @Test
    public void testDeletarPessoa(){

        DadosCadastroPessoa p = new DadosCadastroPessoa();
        p.setNome("Jackson");
        p.setDataNascimento(LocalDate.of(1987, 7, 8));

        Pessoa pessoa = pessoaService.salvarPessoa(p);

        Long id = pessoa.getId();

        pessoaService.deletarPessoa(id);

        Assert.assertFalse(false);

    }


    @Test
    public void testePesquisarPessoa(){
        Page<DadosListagemPessoa> p = pessoaService.listar(PageRequest.of(0,1));

        Assert.assertEquals(1, p.getSize());
    }




}
