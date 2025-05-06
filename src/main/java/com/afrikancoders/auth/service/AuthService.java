package com.afrikancoders.auth.service;

import com.afrikancoders.auth.dtos.LoginDto;
import com.afrikancoders.auth.dtos.RegisterDto;
import com.afrikancoders.auth.entity.Auth;
import com.afrikancoders.auth.response.LoginResponse;

public interface AuthService {

    Auth register(RegisterDto registerDto);
    void login(LoginDto loginDto, boolean sendOtpByEmail);
    LoginResponse login(LoginDto loginDto);


}
