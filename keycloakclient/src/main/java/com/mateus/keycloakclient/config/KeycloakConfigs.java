package com.mateus.keycloakclient.config;

import lombok.Getter;
import lombok.ToString;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

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
}
