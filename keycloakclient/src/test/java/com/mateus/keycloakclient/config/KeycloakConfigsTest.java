package com.mateus.keycloakclient.config;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class KeycloakConfigsTest {

    @Autowired
    private KeycloakConfigs keycloakConfigs;

    @Test
    void DeveriaRetornarAPasswordDefinidaNoApplication(){

        assertEquals("adminPassword", keycloakConfigs.getPassword());
    }

    @Test
    void DeveriaRetornarOUsernameDefinidoNoApplication(){

        assertEquals("admin", keycloakConfigs.getUsername());
    }

    @Test
    void DeveriaRetornarOClientDefinidoNoApplication(){

        assertEquals("web-spring-boot", keycloakConfigs.getClient());
    }

    @Test
    void DeveriaRetornarAUrlDefinidaNoApplication(){

        assertEquals("localhost:8091", keycloakConfigs.getUrl());
    }

}