package com.attornatus.api.pessoas.controller;

import com.attornatus.api.pessoas.dto.usuario.DadosAutenticacao;
import com.attornatus.api.pessoas.infra.security.DadosTokenJWT;
import com.attornatus.api.pessoas.infra.security.TokenService;
import com.attornatus.api.pessoas.model.usuario.Usuario;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Classe responsavel pelas requisições com os metodos Salvar/ para usuario, onde o post faz a verificação se o usuario existe no banco
 * retornado o token caso o usuario esteja cadastrado.
 * Autor: Jackson Santos
 *
 */

@RestController
@RequestMapping("/login")
public class AutenticacaoController {

    @Autowired
    private AuthenticationManager manager;

    @Autowired
    private TokenService tokenService;

    @PostMapping
    public ResponseEntity efetuarLogin(@RequestBody @Valid DadosAutenticacao dados){
        var authenticationToken = new UsernamePasswordAuthenticationToken(dados.login(), dados.senha());
        var authentication = manager.authenticate(authenticationToken);

        var tokenJWT = tokenService.gerarToken((Usuario) authentication.getPrincipal());
        return ResponseEntity.ok(new DadosTokenJWT(tokenJWT));
    }
}
