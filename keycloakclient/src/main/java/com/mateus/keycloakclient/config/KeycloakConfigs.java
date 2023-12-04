package com.mateus.keycloakclient.config;

import lombok.Getter;
import lombok.ToString;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.Map;

@Getter
@Component
@ToString
public class KeycloakConfigs {

    @Value("${keycloak.connection.url}")
    private String url;

    @Value("${keycloak.connection.client}")
    private String client;

    @Value("${keycloak.connection.username}")
    private String username;

    @Value("${keycloak.connection.password}")
    private String password;

    @Value("${keycloak.connection.realm}")
    private String realm;

    @Value("${keycloak.connection.grant_type}")
    private String grantType;

    public Map<String, String> paraformularioDeAutenticacao(){
        Map<String, String> form = new HashMap<>();

        form.put("client_id", this.getClient());
        form.put("username", this.getUsername());
        form.put("password", this.getPassword());
        form.put("grant_type", this.getGrantType());
        return form;
    }
}
