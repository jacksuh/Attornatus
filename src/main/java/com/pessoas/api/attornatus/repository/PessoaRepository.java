package com.pessoas.api.attornatus.repository;

import com.pessoas.api.attornatus.model.Pessoa;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PessoaRepository extends JpaRepository<Pessoa, Long> {

}
