package com.attornatus.api.pessoas.repository;

import com.attornatus.api.pessoas.model.Pessoa;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Classe PessoaRepository -  responsavel por tratamento de requisição ao banco de dados.
 * Autor: Jackson Santos
 *
 */


public interface PessoaRepository extends JpaRepository<Pessoa, Long> {

}
