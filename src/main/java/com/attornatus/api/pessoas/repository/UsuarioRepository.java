package com.attornatus.api.pessoas.repository;

import com.attornatus.api.pessoas.model.usuario.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.security.core.userdetails.UserDetails;

/**
 * Classe UsuarioRepository -  responsavel por tratamento de requisição ao banco de dados, (UserDetails) verificando se existe o usuario no banco de dados .
 * Autor: Jackson Santos
 *
 */

public interface UsuarioRepository extends JpaRepository<Usuario, Long> {
    UserDetails findByLogin(String login);
}
