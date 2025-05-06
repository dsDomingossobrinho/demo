package com.afrikancoders.auth.dtos;

public record RegisterDto(
    String email,
    String password,
    String role
) {
}
