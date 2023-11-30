package com.mateus.keycloakclient.dto;

import com.mateus.keycloakclient.config.KeycloakConfigs;
import lombok.ToString;

public record InformacoesDeAcessoDTO(
        String client_id,
        String username,
        String password,
        String grant_type
) {

    public InformacoesDeAcessoDTO(
            KeycloakConfigs keycloakConfigs
    ) {
        this(
                keycloakConfigs.getClient(),
                keycloakConfigs.getUsername(),
                keycloakConfigs.getPassword(),
                keycloakConfigs.getGrantType()
        );
    }

    public String getClient_id() {
        return client_id;
    }

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }

    public String getGrant_type() {
        return grant_type;
    }
}