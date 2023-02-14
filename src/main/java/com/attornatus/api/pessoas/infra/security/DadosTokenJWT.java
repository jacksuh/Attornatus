package com.attornatus.api.pessoas.infra.security;

/**
 * Classe DadosTokenJWT classe DTO - Data Transfer Object, responsavel pelo retorno do token, utilizado o record do java 17.
 *
 * Autor: Jackson Santos
 */
public record DadosTokenJWT(String token) {
}
