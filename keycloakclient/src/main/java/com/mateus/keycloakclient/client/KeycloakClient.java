package com.mateus.keycloakclient.client;

import com.mateus.keycloakclient.dto.FormularioDeCadastroDeUsuarioDoKeycloakDTO;
import com.mateus.keycloakclient.dto.InformacoesDeConexaoDTO;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@FeignClient(name = "KeycloakClient", url = "http://${keycloak.connection.url}")
public interface KeycloakClient {

    @RequestMapping(
            method = RequestMethod.POST,
            value = "/realms/${keycloak.connection.realm}/protocol/openid-connect/token",
            consumes = "application/x-www-form-urlencoded",
            produces = "application/json"
    )
    InformacoesDeConexaoDTO autenticar(
            @RequestBody Map<String, ?> form
    );

    @RequestMapping(
            method = RequestMethod.POST,
            value = "/admin/realms/${keycloak.connection.realm}/users",
            consumes = "application/json",
            produces = "application/json"
    )
    ResponseEntity criarUsuario(

            @RequestHeader(name = "Authorization")
            String authorizationBearerToken,

            @RequestBody
            FormularioDeCadastroDeUsuarioDoKeycloakDTO form
    );
}