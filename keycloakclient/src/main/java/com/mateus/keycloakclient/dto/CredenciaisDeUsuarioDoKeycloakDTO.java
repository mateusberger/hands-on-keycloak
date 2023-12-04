package com.mateus.keycloakclient.dto;

public record CredenciaisDeUsuarioDoKeycloakDTO(
        String type,
        String value,
        boolean temporary
) {
}
