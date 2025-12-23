package com.adrar.api.dto.auth;


import jakarta.validation.constraints.*;

public record RegisterRequest(
        @NotBlank @Size(min = 3, max = 50) String username,
        @NotBlank @Email String email,
        @NotBlank @Size(min = 6, max = 72) String password
) {}
