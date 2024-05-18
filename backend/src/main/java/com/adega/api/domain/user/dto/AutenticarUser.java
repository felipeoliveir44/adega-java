package com.adega.api.domain.user.dto;

import jakarta.validation.constraints.NotBlank;

public record AutenticarUser(
        @NotBlank
        String email,
        @NotBlank
        String senha
) {
}
