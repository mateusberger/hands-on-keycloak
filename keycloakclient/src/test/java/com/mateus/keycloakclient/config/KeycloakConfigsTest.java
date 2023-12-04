package com.mateus.keycloakclient.config;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Map;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class KeycloakConfigsTest {

    @Autowired
    private KeycloakConfigs keycloakConfigs;

    @Test
    void deveriaRetornarAPasswordDefinidaNoApplication(){

        assertEquals("admin", keycloakConfigs.getPassword());
    }

    @Test
    void deveriaRetornarOUsernameDefinidoNoApplication(){

        assertEquals("admin", keycloakConfigs.getUsername());
    }

    @Test
    void deveriaRetornarOClientDefinidoNoApplication(){

        assertEquals("web-spring-boot", keycloakConfigs.getClient());
    }

    @Test
    void deveriaRetornarAUrlDefinidaNoApplication(){

        assertEquals("localhost:8091", keycloakConfigs.getUrl());
    }

    @Test
    void deveriaRetornarORealmDefinidoNoApplication(){

        assertEquals("master", keycloakConfigs.getRealm());
    }

    @Test
    void deveriaRetornarUmMapComAsConfiguracoesDeAcesso(){

        Map<String, String> form = keycloakConfigs.paraformularioDeAutenticacao();

        assertEquals("web-spring-boot", form.get("client_id"));
        assertEquals("admin", form.get("username"));
        assertEquals("admin", form.get("password"));
        assertEquals("password", form.get("grant_type"));
    }

}