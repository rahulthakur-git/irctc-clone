package com.rahul.irctc.service;

import com.rahul.irctc.dto.LoginRequestDto;
import com.rahul.irctc.dto.LoginResponseDto;
import com.rahul.irctc.entity.User;
import com.rahul.irctc.repository.UserRepository;
import com.rahul.irctc.security.JwtService;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service

public class AuthServiceImpl implements AuthService{
    private final UserRepository userRepository;
    private final JwtService jwtService;
    private final PasswordEncoder passwordEncoder;
    public AuthServiceImpl(UserRepository userRepository, JwtService jwtService, PasswordEncoder passwordEncoder) {
        this.userRepository = userRepository;
        this.jwtService = jwtService;
        this.passwordEncoder = passwordEncoder;
    }

    @Override
    public LoginResponseDto login(LoginRequestDto loginRequestDto) {
        User user = userRepository.findByEmail(loginRequestDto.getEmail())
                .orElseThrow(() -> new RuntimeException("Invalid Email or Password"));

        if (!passwordEncoder.matches(
                loginRequestDto.getPassword(),
                user.getPassword())) {

            throw new RuntimeException("Invalid Email or Password");
        }

        String token = jwtService.generateToken(user);

        return new LoginResponseDto(token);
    }

}
