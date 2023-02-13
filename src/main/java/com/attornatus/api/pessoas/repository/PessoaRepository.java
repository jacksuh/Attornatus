package com.attornatus.api.pessoas.repository;

import com.attornatus.api.pessoas.model.Pessoa;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PessoaRepository extends JpaRepository<Pessoa, Long> {

}
