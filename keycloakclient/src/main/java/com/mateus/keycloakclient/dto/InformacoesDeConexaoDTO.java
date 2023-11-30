package com.mateus.keycloakclient.dto;

public record InformacoesDeConexaoDTO(
        String access_token,
        Long expires_in,
        String token_type
) {
}