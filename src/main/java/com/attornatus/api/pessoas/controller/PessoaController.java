package com.attornatus.api.pessoas.controller;


import com.attornatus.api.pessoas.dto.pessoa.DadosCadastroPessoa;
import com.attornatus.api.pessoas.model.Pessoa;
import com.attornatus.api.pessoas.service.PessoaService;
import com.attornatus.api.pessoas.dto.pessoa.DadosAtualizarPessoa;
import com.attornatus.api.pessoas.dto.pessoa.DadosDetalhamentoPessoa;
import com.attornatus.api.pessoas.dto.pessoa.DadosListagemPessoa;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

@RestController
@RequestMapping("pessoas")
public class PessoaController {

    @Autowired
    private PessoaService service;

    @PostMapping
    public ResponseEntity cadastrar(@RequestBody @Valid DadosCadastroPessoa dados, UriComponentsBuilder uriBuilder){
        var pessoa = service.salvarPessoa(dados);
        var uri = uriBuilder.path("/pessoas/{id}").buildAndExpand(pessoa.getId()).toUri();

        return ResponseEntity.created(uri).body(new DadosDetalhamentoPessoa(pessoa));
    }


    @GetMapping
    public ResponseEntity<Page<DadosListagemPessoa>> listar(@PageableDefault(size = 10, sort ={"nome"})Pageable paginacao){
        var page = service.listar(paginacao);
        return ResponseEntity.ok(page);
    }


    @PutMapping
    public ResponseEntity atualizar (@RequestBody @Valid DadosAtualizarPessoa dados){

        Pessoa p = service.atualizarPessoa(dados);

        return ResponseEntity.ok(new DadosDetalhamentoPessoa(p));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity deletarFuncionario(@PathVariable("id") Long id){
        service.deletarPessoa(id);

        return ResponseEntity.noContent().build();
    }


}
