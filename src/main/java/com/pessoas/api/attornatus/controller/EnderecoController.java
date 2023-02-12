package com.pessoas.api.attornatus.controller;

import com.pessoas.api.attornatus.dto.endereco.*;
import com.pessoas.api.attornatus.model.Endereco;
import com.pessoas.api.attornatus.repository.EnderecoRepository;
import com.pessoas.api.attornatus.service.EnderecoService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

@RestController
@RequestMapping("endereco")
public class EnderecoController {


    @Autowired
    private EnderecoService service;

    @Autowired
    private EnderecoRepository repository;

    @PostMapping
    public ResponseEntity cadastrar(@RequestBody @Valid  DadosCadastrarEndereco dados, UriComponentsBuilder uriBuilder){
        var endereco = service.salvarEndereco(dados);
        repository.save(endereco);
        var uri = uriBuilder.path("/endereco/{id}").buildAndExpand(endereco.getId()).toUri();

        return ResponseEntity.created(uri).body(new DadosDetalhamentoEndereco(endereco));
    }

    @PutMapping
    public ResponseEntity atualizar (@RequestBody @Valid DadosAtualizarEndereco dados){

        Endereco p = service.atualizarEndereco(dados);

        return ResponseEntity.ok(new DadosDetalhamentoEndereco(p));
    }


    @GetMapping
    public ResponseEntity<Page<DadosListagemEndereco>> listarAtivo(@PageableDefault(size = 10, sort = {"logradouro"}) Pageable paginacao){
        var page = service.listar(paginacao);
        return ResponseEntity.ok(page);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity excluir(@PathVariable Long id){
        service.deletarEndereco(id);
        return ResponseEntity.noContent().build();
    }

    
}
