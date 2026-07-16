package com.rahul.irctc.security;

import com.rahul.irctc.entity.User;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jws;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.security.Keys;
import org.springframework.stereotype.Service;

import javax.crypto.SecretKey;
import java.security.Key;
import java.util.Date;

@Service

public class JwtService {
    private static final String SECRET = "MySuperSecretKeyForIRCTCProjectJwtAuthentication123456789";
    private final SecretKey key = Keys.hmacShaKeyFor(SECRET.getBytes());
    public String generateToken(User user){
        return Jwts.builder()
                .subject(user.getEmail())
                .issuedAt(new Date())
                .expiration(new Date(System.currentTimeMillis()+1000*60*60))
                .signWith(key)
                .compact();
    }
    public String extractUsername(String token){
        Jws<Claims> claims = Jwts.parser().verifyWith(key).build().parseSignedClaims(token);
        return claims.getPayload().getSubject();
    }
}
