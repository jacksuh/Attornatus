package com.pessoas.api.attornatus.controller;


import com.pessoas.api.attornatus.dto.DadosAtualizarPessoa;
import com.pessoas.api.attornatus.dto.DadosCadastroPessoa;
import com.pessoas.api.attornatus.dto.DadosDetalhamentoPessoa;
import com.pessoas.api.attornatus.dto.DadosListagemPessoa;
import com.pessoas.api.attornatus.pessoa.Pessoa;
import com.pessoas.api.attornatus.pessoa.PessoaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

@RestController
@RequestMapping("pessoas")
public class PessoaController {

    @Autowired
    private PessoaRepository repository;

    @PostMapping
    public ResponseEntity cadastrar(@RequestBody DadosCadastroPessoa dados, UriComponentsBuilder uriBuilder){
        var pessoa = new Pessoa(dados);
        repository.save(pessoa);
        var uri = uriBuilder.path("/pessoas/{id}").buildAndExpand(pessoa.getId()).toUri();

        return ResponseEntity.created(uri).body(new DadosDetalhamentoPessoa(pessoa));
    }

    @GetMapping
    public ResponseEntity<Page<DadosListagemPessoa>> listar(@PageableDefault(size = 10, sort ={"nome"})Pageable paginacao){
        var page = repository.findAll(paginacao).map(DadosListagemPessoa::new);
         return ResponseEntity.ok(page);
    }

    @PutMapping
    public ResponseEntity atualizar (@RequestBody  DadosAtualizarPessoa dados){
        var pessoa = repository.getReferenceById(dados.id());
        pessoa.atualizarInformacoes(dados);
        repository.save(pessoa);
        return ResponseEntity.ok(new DadosDetalhamentoPessoa(pessoa));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity excluir(@PathVariable Long id){
        var pessoa = repository.getReferenceById(id);
        repository.delete(pessoa);
            return ResponseEntity.noContent().build();
    }






}
