package com.attornatus.api.pessoas.endereco;

import com.attornatus.api.pessoas.dto.endereco.DadosCadastrarEndereco;
import com.attornatus.api.pessoas.dto.endereco.DadosListagemEndereco;
import com.attornatus.api.pessoas.dto.pessoa.DadosCadastroPessoa;
import com.attornatus.api.pessoas.dto.pessoa.DadosPessoa;
import com.attornatus.api.pessoas.model.Pessoa;
import com.attornatus.api.pessoas.service.PessoaService;
import com.attornatus.api.pessoas.dto.endereco.DadosAtualizarEndereco;
import com.attornatus.api.pessoas.model.Endereco;
import com.attornatus.api.pessoas.repository.PessoaRepository;
import com.attornatus.api.pessoas.service.EnderecoService;
import org.junit.Assert;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.HttpStatus;
import org.springframework.web.server.ResponseStatusException;

import java.time.LocalDate;

/**
 * Classe EnderecoTest, responsavel por Testar das regras Salvar,Listar,Atualizar,Deletar .
 * Autor: Jackson Santos
 */


@SpringBootTest
public class EnderecoTest {

    @Autowired
    private EnderecoService service;

    @Autowired
    private PessoaService pessoaService;
    @Autowired
    private PessoaRepository pessoaRepository;

    @Test
    public void testeSalvar(){

        DadosCadastroPessoa p = new DadosCadastroPessoa();
        p.setNome("Jackson");
        p.setDataNascimento(LocalDate.of(1987, 7, 8));

        Pessoa pessoa = pessoaService.salvarPessoa(p);

        Long id = pessoa.getId();

        DadosPessoa pessoas = new DadosPessoa(pessoa);
        Long idDescricao = pessoas.getId();
        Pessoa pes =
                pessoaRepository.findById(idDescricao)
                        .orElseThrow(()-> new ResponseStatusException(HttpStatus.BAD_REQUEST, "Endereco não encontrado"));



        DadosCadastrarEndereco cadastrar = new DadosCadastrarEndereco();
        cadastrar.setLogradouro("rua 1");
        cadastrar.setCep("12345678");
        cadastrar.setNumero("35");
        cadastrar.setCidade("São Paulo");
        cadastrar.setPessoa(pessoas);

        service.salvarEndereco(cadastrar);

        Assert.assertEquals("rua 1", cadastrar.getLogradouro());
        Assert.assertEquals("35", cadastrar.getNumero());
    }

    @Test
    public void testAtualizacaoPessoa(){
        DadosCadastroPessoa p = new DadosCadastroPessoa();
        p.setNome("Jackson");
        p.setDataNascimento(LocalDate.of(1987, 7, 8));

        Pessoa pessoa = pessoaService.salvarPessoa(p);

        Long id = pessoa.getId();

        DadosPessoa pessoas = new DadosPessoa(pessoa);
        Long idDescricao = pessoas.getId();
        Pessoa pes =
                pessoaRepository.findById(idDescricao)
                        .orElseThrow(()-> new ResponseStatusException(HttpStatus.BAD_REQUEST, "Endereco não encontrado"));



        DadosCadastrarEndereco cadastrar = new DadosCadastrarEndereco();
        cadastrar.setLogradouro("rua 1");
        cadastrar.setCep("12345678");
        cadastrar.setNumero("35");
        cadastrar.setCidade("São Paulo");
        cadastrar.setPessoa(pessoas);

        service.salvarEndereco(cadastrar);



        DadosAtualizarEndereco atualizar = new DadosAtualizarEndereco();
        atualizar.setId(id);
        atualizar.setLogradouro("rua 2");
        atualizar.setCep("12345678");
        atualizar.setNumero("34");
        atualizar.setCidade("São Paulo");
        atualizar.setPessoa(pessoas);

        service.atualizarEndereco(atualizar);

        Assert.assertEquals("rua 2", atualizar.getLogradouro());
        Assert.assertEquals("34", atualizar.getNumero());
    }



    @Test
    public void testDeletarEndereco(){
        DadosCadastroPessoa p = new DadosCadastroPessoa();
        p.setNome("Jackson");
        p.setDataNascimento(LocalDate.of(1987, 7, 8));

        Pessoa pessoa = pessoaService.salvarPessoa(p);

        Long id = pessoa.getId();

        DadosPessoa pessoas = new DadosPessoa(pessoa);
        Long idDescricao = pessoas.getId();
        Pessoa pes =
                pessoaRepository.findById(idDescricao)
                        .orElseThrow(()-> new ResponseStatusException(HttpStatus.BAD_REQUEST, "Endereco não encontrado"));


        DadosCadastrarEndereco e = new DadosCadastrarEndereco();
        e.setLogradouro("rua 1");
        e.setCep("12345678");
        e.setNumero("35");
        e.setCidade("São Paulo");
        e.setPessoa(pessoas);

        Endereco endereco = service.salvarEndereco(e);

        Long ids = endereco.getId();

        service.deletarEndereco(ids);

        Assert.assertFalse(false);

    }

    @Test
    public void testePesquisarEndereco(){
        DadosCadastroPessoa pes = new DadosCadastroPessoa();
        pes.setNome("Jackson");
        pes.setDataNascimento(LocalDate.of(1987, 7, 8));

        Pessoa pessoa = pessoaService.salvarPessoa(pes);

        Page<DadosListagemEndereco> p = service.listar(PageRequest.of(1,1));

        Assert.assertEquals(1, p.getSize());
    }
}
