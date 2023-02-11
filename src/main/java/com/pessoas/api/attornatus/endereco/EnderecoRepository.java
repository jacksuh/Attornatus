package com.pessoas.api.attornatus.endereco;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;


public interface EnderecoRepository extends JpaRepository<Endereco, Long> {

    Page<Endereco> findAllByAtivoTrue(Pageable paginacao);
}
