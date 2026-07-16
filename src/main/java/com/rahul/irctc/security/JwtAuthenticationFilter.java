package com.rahul.irctc.security;

import com.rahul.irctc.entity.User;
import com.rahul.irctc.repository.UserRepository;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import java.io.IOException;
import java.net.http.HttpResponse;

@Component

public class JwtAuthenticationFilter extends OncePerRequestFilter {
    public final JwtService jwtService;
    private final UserRepository userRepository;

    public JwtAuthenticationFilter(JwtService jwtService, UserRepository userRepository) {
        this.jwtService = jwtService;
        this.userRepository = userRepository;
    }


    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws ServletException, IOException {
        String authHeader = request.getHeader("Authorization");
        if(authHeader==null || !authHeader.startsWith("Bearer")){
            filterChain.doFilter(request,response);
            return;
        }
        String jwt = authHeader.substring(7);
        String email = jwtService.extractUsername(jwt);
        User user = userRepository.findByEmail(email)
                        .orElseThrow(()-> new RuntimeException("User not found"));
        System.out.println(user.getEmail());
        System.out.println(email);
        System.out.println(jwt);
        filterChain.doFilter(request,response);

    }
}
