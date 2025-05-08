package com.afrikancoders.auth.service;

import org.springframework.http.ResponseEntity;

import com.afrikancoders.auth.dtos.KeycloackRegisterDto;
import com.afrikancoders.auth.dtos.LoginDto;
import com.afrikancoders.auth.dtos.LoginSwaggerDto;
import com.afrikancoders.auth.dtos.RegisterDto;
import com.afrikancoders.auth.entity.Auth;
import com.afrikancoders.auth.response.LoginResponse;
import com.afrikancoders.auth.response.LoginSwaggerResponse;


public interface AuthService {

    Auth register(RegisterDto registerDto);

    ResponseEntity<LoginSwaggerResponse> loginSwagger(LoginSwaggerDto loginSwaggerDto);
    
    void login(LoginDto loginDto, boolean sendOtpByEmail);

    LoginResponse login(LoginDto loginDto);

    String registerUserKeycloack(KeycloackRegisterDto keycloackRegisterDto, String bearerToken);

    void editUserKeycloack(String keycloackId, KeycloackRegisterDto keycloackRegisterDto, String bearerToken);

    void deleteUserKeycloack(String keycloackId, String bearerToken);


}
