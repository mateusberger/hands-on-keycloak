package com.mateus.keycloakclient.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;


@Component
public class KeycloakConfigs {

    @Value("${keycloak.connection.url}")
    private String url;

    @Value("${keycloak.connection.client}")
    private String client;

    @Value("${keycloak.connection.username}")
    private String username;

    @Value("${keycloak.connection.password}")
    private String password;

    public String getUrl() {
        return url;
    }

    public String getClient() {
        return client;
    }

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }
}
