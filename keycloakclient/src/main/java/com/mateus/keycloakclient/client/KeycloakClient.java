package com.mateus.keycloakclient.client;

import com.mateus.keycloakclient.dto.InformacoesDeConexaoDTO;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.Map;

@FeignClient(name = "KeycloakClient", url = "http://${keycloak.connection.url}")
public interface KeycloakClient {

    @RequestMapping(
            method = RequestMethod.POST,
            value = "/realms/${keycloak.connection.realm}/protocol/openid-connect/token",
            consumes = "application/x-www-form-urlencoded",
            produces = "application/json"
    )
    InformacoesDeConexaoDTO acessarKeycloak(
            @RequestBody Map<String, ?> form
    );

}