package com.mateus.keycloakclient.client;

import com.mateus.keycloakclient.config.KeycloakConfigs;
import com.mateus.keycloakclient.dto.CredenciaisDeUsuarioDoKeycloakDTO;
import com.mateus.keycloakclient.dto.FormularioDeCadastroDeUsuarioDoKeycloakDTO;
import com.mateus.keycloakclient.dto.InformacoesDeConexaoDTO;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.ResponseEntity;

import java.util.Collections;
import java.util.UUID;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

@SpringBootTest
class KeycloakClientIT {

    @Autowired
    private KeycloakClient keycloakClient;

    @Autowired
    private KeycloakConfigs keycloakConfigs;

    @Test
    void deveriaRetornarInformacoesDeConexao_quandoEnviadoInformacoesDeAcesso() {

        InformacoesDeConexaoDTO informacoesDeConexaoDTO = keycloakClient.autenticar(
                keycloakConfigs.paraformularioDeAutenticacao()
        );

        assertNotNull(informacoesDeConexaoDTO);
        assertNotNull(informacoesDeConexaoDTO.access_token());
        assertNotNull(informacoesDeConexaoDTO.token_type());
        assertNotNull(informacoesDeConexaoDTO.expires_in());
    }

    @Test
    void deveriaCriarUmUsuarioNovo() {

        InformacoesDeConexaoDTO informacoesDeConexaoDTO = keycloakClient.autenticar(
                keycloakConfigs.paraformularioDeAutenticacao()
        );

        String token = "Bearer " + informacoesDeConexaoDTO.access_token();

        FormularioDeCadastroDeUsuarioDoKeycloakDTO formularioDeCadastroDeUsuarioDoKeycloakDTO = new FormularioDeCadastroDeUsuarioDoKeycloakDTO(
                "newUser" + UUID.randomUUID().toString().substring(0,7),
                true,
                UUID.randomUUID().toString().substring(0,7) + "@email.com.br",
                "Fulano",
                "Sobreno Medefulano",
                Collections.singletonList(new CredenciaisDeUsuarioDoKeycloakDTO(
                        "password",
                        "senha@123",
                        false
                ))
        );

        ResponseEntity responseEntity = keycloakClient.criarUsuario(
                token,
                formularioDeCadastroDeUsuarioDoKeycloakDTO
        );

        assertEquals(201, responseEntity.getStatusCode().value());
    }
}