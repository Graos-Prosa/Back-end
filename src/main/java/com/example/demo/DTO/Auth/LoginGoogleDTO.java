package com.example.demo.DTO.Auth;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;

public record LoginGoogleDTO(
        String token
) {}

