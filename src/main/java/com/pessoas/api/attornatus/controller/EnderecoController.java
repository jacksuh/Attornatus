package com.pessoas.api.attornatus.controller;

import com.pessoas.api.attornatus.dto.endereco.DadosAtualizarEnderecoAtivo;
import com.pessoas.api.attornatus.dto.endereco.DadosCadastrarEndereco;
import com.pessoas.api.attornatus.dto.endereco.DadosDetalhamentoEndereco;
import com.pessoas.api.attornatus.dto.endereco.DadosListagemEndereco;
import com.pessoas.api.attornatus.endereco.Endereco;
import com.pessoas.api.attornatus.endereco.EnderecoRepository;
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
    private EnderecoRepository repository;

    @PostMapping
    public ResponseEntity cadastrar(@RequestBody DadosCadastrarEndereco dados, UriComponentsBuilder uriBuilder){
        var endereco = new Endereco(dados);
        repository.save(endereco);
        var uri = uriBuilder.path("/endereco/{id}").buildAndExpand(endereco.getId()).toUri();

        return ResponseEntity.created(uri).body(new DadosDetalhamentoEndereco(endereco));
    }


    @PutMapping
    public ResponseEntity enderecoPrincipal(@RequestBody DadosAtualizarEnderecoAtivo dados){
        var endereco = repository.getReferenceById(dados.getId());
        endereco.atualizarInformacoes(dados);
        repository.save(endereco);
        return ResponseEntity.ok(new DadosDetalhamentoEndereco(endereco));
    }

    @GetMapping
    public ResponseEntity<Page<DadosListagemEndereco>> listarAtivo(@PageableDefault(size = 10, sort = {"logradouro"}) Pageable paginacao){
        var page = repository.findAll(paginacao).map(DadosListagemEndereco::new);
        return ResponseEntity.ok(page);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity excluir(@PathVariable Long id){
        var endereco = repository.getReferenceById(id);
        repository.delete(endereco);
        return ResponseEntity.noContent().build();
    }

    
}
