package com.attornatus.api.pessoas.repository;

import com.attornatus.api.pessoas.model.Endereco;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Classe EnderecoRepository -  responsavel por tratamento de requisição ao banco de dados.
 * Autor: Jackson Santos
 *
 */

public interface EnderecoRepository extends JpaRepository<Endereco, Long> {

    Page<Endereco> findAllByAtivoTrue(Pageable paginacao);
}
