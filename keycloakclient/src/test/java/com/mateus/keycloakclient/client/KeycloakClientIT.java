package com.mateus.keycloakclient.client;

import com.mateus.keycloakclient.config.KeycloakConfigs;
import com.mateus.keycloakclient.dto.InformacoesDeAcessoDTO;
import com.mateus.keycloakclient.dto.InformacoesDeConexaoDTO;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.HashMap;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class KeycloakClientIT {

    @Autowired
    private KeycloakClient keycloakClient;

    @Autowired
    private KeycloakConfigs keycloakConfigs;

    @Test
    void deveriaRetornarInformacoesDeConexao_quandoEnviadoInformacoesDeAcesso(){

        System.out.println("aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa");

        Map<String, String> form = new HashMap<>();

        form.put("client_id", keycloakConfigs.getClient());
        form.put("username", keycloakConfigs.getUsername());
        form.put("password", keycloakConfigs.getPassword());
        form.put("grant_type", keycloakConfigs.getGrantType());

        InformacoesDeConexaoDTO informacoesDeConexaoDTO = keycloakClient.acessarKeycloak(
                form
        );

        assertNotNull(informacoesDeConexaoDTO);
        assertNotNull(informacoesDeConexaoDTO.access_token());
        assertNotNull(informacoesDeConexaoDTO.token_type());
        assertNotNull(informacoesDeConexaoDTO.expires_in());
    }
}