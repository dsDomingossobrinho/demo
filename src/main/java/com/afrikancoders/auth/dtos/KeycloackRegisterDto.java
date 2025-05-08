package com.afrikancoders.auth.dtos;

import java.util.List;

public record KeycloackRegisterDto(
    
    String username,
    String email,
    String nome,
    String sobrenome,
    String senha,
    List<String> roles
) {
    
}
