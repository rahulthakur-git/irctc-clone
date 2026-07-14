package com.rahul.irctc.controller;

import com.rahul.irctc.dto.LoginRequestDto;
import com.rahul.irctc.dto.LoginResponseDto;
import com.rahul.irctc.service.AuthService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController

@RequestMapping("/api/auth")

public class AuthController {
    private final AuthService authService;

    public AuthController(AuthService authService) {
        this.authService = authService;
    }

    @PostMapping("/login")
    public LoginResponseDto login(@RequestBody LoginRequestDto loginRequestDto){
        return authService.login(loginRequestDto);
    }
}
