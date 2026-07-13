package com.rahul.irctc.service;

import com.rahul.irctc.dto.LoginRequestDto;
import com.rahul.irctc.dto.LoginResponseDto;

public interface AuthService {
    LoginResponseDto login(LoginRequestDto loginRequestDto);
}
