package com.afrikancoders.auth.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

//import com.afrikancoders.auth.dtos.KeycloackRegisterDto;
import com.afrikancoders.auth.dtos.LoginSwaggerDto;
import com.afrikancoders.auth.response.LoginSwaggerResponse;
import com.afrikancoders.auth.service.AuthService;
import com.afrikancoders.security.SecurityConfig;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
//import jakarta.servlet.http.HttpServletRequest;
import lombok.RequiredArgsConstructor;

//import java.util.Map;

//import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
//import org.springframework.web.bind.annotation.DeleteMapping;
//import org.springframework.web.bind.annotation.GetMapping;
//import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
//import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;


@RestController
@RequestMapping("/auth")
@RequiredArgsConstructor
@SecurityRequirement(name= SecurityConfig.SECURITY)
public class AuthController {

    private final AuthService authService;

    @PostMapping("/login")
    @Operation(tags = "Authentication")
    public ResponseEntity<LoginSwaggerResponse> login(@RequestBody LoginSwaggerDto loginSwaggerDto) { 
        
        return authService.loginSwagger(loginSwaggerDto);
    }

    /*
    @PostMapping("/usuarios")
    @Operation(tags = "Authentication")
    public ResponseEntity<Map<String, String>> criarUsuario(
        @RequestBody KeycloackRegisterDto dto,
        HttpServletRequest request
    ) {
        String authHeader = request.getHeader("Authorization");
        if (authHeader == null || !authHeader.startsWith("Bearer ")) {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body(Map.of("error", "Token JWT não fornecido."));
        }

        String token = authHeader.substring(7);
        String userId = authService.registerUserKeycloack(dto, token);
        return ResponseEntity.status(HttpStatus.CREATED).body(Map.of("userId", userId));
    }
    
    @PutMapping("/usuarios/{id}")
    @Operation(tags = "Authentication")
    public void editUsuario(
        @PathVariable String id,
        @RequestBody KeycloackRegisterDto dto,
        HttpServletRequest request
    ) {
        String authHeader = request.getHeader("Authorization");
        if (authHeader == null || !authHeader.startsWith("Bearer ")) {
            return; //ResponseEntity.status(HttpStatus.UNAUTHORIZED).body(Map.of("error", "Token JWT não fornecido."));
        }

        String token = authHeader.substring(7);
        authService.editUserKeycloack(id,dto, token);
        
    }

    @DeleteMapping("/usuarios/{id}")
    @Operation(tags = "Authentication")
    public void deleteUsuario(
        @PathVariable String id,
        HttpServletRequest request
    ) {
        String authHeader = request.getHeader("Authorization");
        if (authHeader == null || !authHeader.startsWith("Bearer ")) {
            return; //ResponseEntity.status(HttpStatus.UNAUTHORIZED).body(Map.of("error", "Token JWT não fornecido."));
        }

        String token = authHeader.substring(7);
        authService.deleteUserKeycloack(id, token);
        
    }
        
    */

    
}
