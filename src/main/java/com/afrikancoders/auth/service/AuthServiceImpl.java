package com.afrikancoders.auth.service;

import org.springframework.stereotype.Service;

import com.afrikancoders.auth.dtos.LoginDto;
import com.afrikancoders.auth.dtos.RegisterDto;
import com.afrikancoders.auth.entity.Auth;
import com.afrikancoders.auth.response.LoginResponse;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class AuthServiceImpl implements AuthService {@Override
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

    
}
