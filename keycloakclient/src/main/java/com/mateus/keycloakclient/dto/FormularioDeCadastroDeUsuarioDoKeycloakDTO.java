package com.mateus.keycloakclient.dto;

import java.util.List;

public record FormularioDeCadastroDeUsuarioDoKeycloakDTO(
        String username,
        boolean enabled,
        String email,
        String firstName,
        String lastName,
        List<CredenciaisDeUsuarioDoKeycloakDTO> credentials
) {
}
