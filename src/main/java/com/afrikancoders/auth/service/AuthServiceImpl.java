package com.afrikancoders.auth.service;


import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Value;

import com.afrikancoders.auth.dtos.KeycloackRegisterDto;
import com.afrikancoders.auth.dtos.LoginDto;
import com.afrikancoders.auth.dtos.LoginSwaggerDto;
import com.afrikancoders.auth.dtos.RegisterDto;
import com.afrikancoders.auth.entity.Auth;
import com.afrikancoders.auth.response.LoginResponse;
import com.afrikancoders.auth.response.LoginSwaggerResponse;

import lombok.RequiredArgsConstructor;


@Service
@RequiredArgsConstructor
public class AuthServiceImpl implements AuthService {

    @Value("${spring.security.oauth2.client.registration.keycloak.client-id}")
    private String clientId;

    @Value("${spring.security.oauth2.client.registration.keycloak.client-secret}")
    private String clientSecret;

    @Value("${spring.security.oauth2.client.registration.keycloak.authorization-grant-type}")
    private String grantType;

    private final RestTemplate restTemplate = new RestTemplate();
    private final String KEYCLOAK_BASE_URL = "https://auth-utg.sintaxy.com/auth";
    private final String REALM = "AfrikanCoders";


    @Override
    public Auth register(RegisterDto registerDto) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'register'");
    }

    @Override
    public void login(LoginDto loginDto, boolean sendOtpByEmail) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'login'");
    }

    @Override
    public LoginResponse login(LoginDto loginDto) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'login'");
    }

    @Override
    public ResponseEntity<LoginSwaggerResponse> loginSwagger(LoginSwaggerDto loginSwaggerDto) {
        String tokenUrl = KEYCLOAK_BASE_URL + "/realms/" + REALM + "/protocol/openid-connect/token";
        MultiValueMap<String, String> requestBody = new LinkedMultiValueMap<>();
        requestBody.add("grant_type", "password");
        requestBody.add("client_id", clientId);
        requestBody.add("client_secret", clientSecret);
        requestBody.add("username", loginSwaggerDto.username());
        requestBody.add("password", loginSwaggerDto.password());

        HttpHeaders headers = new HttpHeaders();

        headers.setContentType(MediaType.APPLICATION_FORM_URLENCODED);

        HttpEntity<MultiValueMap<String, String>> requestEntity = new HttpEntity<>(requestBody, headers);

        ResponseEntity<Map> response = restTemplate.exchange(tokenUrl, HttpMethod.POST, requestEntity, Map.class);


            String accessToken = (String) response.getBody().get("access_token");
            return ResponseEntity.ok(new LoginSwaggerResponse(accessToken));

    }

    @Override
    public String registerUserKeycloack(KeycloackRegisterDto dto, String bearerToken) {
        HttpHeaders headers = new HttpHeaders();
        headers.setBearerAuth(bearerToken);
        headers.setContentType(MediaType.APPLICATION_JSON);

        Map<String, Object> userPayload = new HashMap<>();
        userPayload.put("username", dto.username());
        userPayload.put("enabled", true);
        userPayload.put("email", dto.email());
        if (dto.nome() != null) {
            userPayload.put("firstName", dto.nome());

        }

        if (dto.sobrenome() != null) {
            userPayload.put("lastName", dto.sobrenome());
  
        }

        HttpEntity<Map<String, Object>> userRequest = new HttpEntity<>(userPayload, headers);
        restTemplate.postForEntity(KEYCLOAK_BASE_URL + "/admin/realms/" + REALM + "/users", userRequest, Void.class);

        String searchUrl = KEYCLOAK_BASE_URL + "/admin/realms/" + REALM + "/users?username=" + dto.username();
        ResponseEntity<List> searchResponse = restTemplate.exchange(searchUrl, HttpMethod.GET, new HttpEntity<>(headers), List.class);

        if (searchResponse.getBody() == null || searchResponse.getBody().isEmpty()) {
            throw new RuntimeException("Usuário não encontrado após criação.");
        }

        String userId = (String) ((Map<String, Object>) searchResponse.getBody().get(0)).get("id");

        Map<String, Object> senhaPayload = Map.of(
            "type", "password",
            "value", dto.senha(),
            "temporary", false
        );
        restTemplate.put(
            KEYCLOAK_BASE_URL + "/admin/realms/" + REALM + "/users/" + userId + "/reset-password",
            new HttpEntity<>(senhaPayload, headers)
        );

        if (dto.roles() != null && !dto.roles().isEmpty()) {
            List<Map<String, Object>> roleRepresentations = new ArrayList<>();

            for (String roleName : dto.roles()) {
                Map role = restTemplate.exchange(
                    KEYCLOAK_BASE_URL + "/admin/realms/" + REALM + "/roles/" + roleName,
                    HttpMethod.GET,
                    new HttpEntity<>(headers),
                    Map.class
                ).getBody();

                if (role != null) {
                    roleRepresentations.add(role);
                }
            }

            restTemplate.postForEntity(
                KEYCLOAK_BASE_URL + "/admin/realms/" + REALM + "/users/" + userId + "/role-mappings/realm",
                new HttpEntity<>(roleRepresentations, headers),
                Void.class
            );
        }

        return userId;
    }

    @Override
    public void editUserKeycloack(String keycloackId, KeycloackRegisterDto dto, String bearerToken) {

        /*if (dto.username()!=null) {
            this.deleteUserKeycloack(keycloackId, bearerToken);
            this.registerUserKeycloack(dto, bearerToken);
            return;
        }*/
        HttpHeaders headers = new HttpHeaders();
        headers.setBearerAuth(bearerToken);
        headers.setContentType(MediaType.APPLICATION_JSON);

        Map<String, Object> updatePayload = new HashMap<>();
        
        if (dto.email() != null) {
            updatePayload.put("email", dto.email());
        }
        if (dto.nome() != null) {
            updatePayload.put("firstName", dto.nome());

        }
        if (dto.sobrenome() != null) {
            updatePayload.put("lastName", dto.sobrenome());
  
        }
        
        updatePayload.put("enabled", true);

        HttpEntity<Map<String, Object>> request = new HttpEntity<>(updatePayload, headers);

        restTemplate.exchange(
            KEYCLOAK_BASE_URL + "/admin/realms/" + REALM + "/users/" + keycloackId,
            HttpMethod.PUT,
            request,
            Void.class
        );

        if (dto.senha() != null && !dto.senha().isBlank()) {
            Map<String, Object> senhaPayload = Map.of(
                "type", "password",
                "value", dto.senha(),
                "temporary", false
            );

            restTemplate.put(
                KEYCLOAK_BASE_URL + "/admin/realms/" + REALM + "/users/" + keycloackId + "/reset-password",
                new HttpEntity<>(senhaPayload, headers)
            );
        }

        if (dto.roles() != null && !dto.roles().isEmpty()) {
            restTemplate.exchange(
            KEYCLOAK_BASE_URL + "/admin/realms/" + REALM + "/users/" + keycloackId + "/role-mappings/realm",
            HttpMethod.DELETE,
            new HttpEntity<>(headers),
            Void.class
        );

            List<Map<String, Object>> roleList = new ArrayList<>();
            for (String roleName : dto.roles()) {
                Map role = restTemplate.exchange(
                    KEYCLOAK_BASE_URL + "/admin/realms/" + REALM + "/roles/" + roleName,
                    HttpMethod.GET,
                    new HttpEntity<>(headers),
                    Map.class
                ).getBody();

                if (role != null) {
                    roleList.add(role);
                }
            }

            restTemplate.postForEntity(
                KEYCLOAK_BASE_URL + "/admin/realms/" + REALM + "/users/" + keycloackId + "/role-mappings/realm",
                new HttpEntity<>(roleList, headers),
                Void.class
            );
        }
    }

    @Override
    public void deleteUserKeycloack(String keycloackId, String bearerToken) {
        HttpHeaders headers = new HttpHeaders();
        headers.setBearerAuth(bearerToken);

        HttpEntity<Void> request = new HttpEntity<>(headers);

        restTemplate.exchange(
            KEYCLOAK_BASE_URL + "/admin/realms/" + REALM + "/users/" + keycloackId,
            HttpMethod.DELETE,
            request,
            Void.class
        );
    }

    

    
}
