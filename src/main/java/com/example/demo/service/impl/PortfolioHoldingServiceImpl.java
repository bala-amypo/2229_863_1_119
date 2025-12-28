package com.example.demo.security;

import org.springframework.stereotype.Component;

@Component
public class JwtUtil {

    public String generateToken(String email, String role, Long userId) {
        return email + "|" + role + "|" + userId;
    }

    public boolean validateToken(String token) {
        return token != null && token.contains("|");
    }

    public String extractEmail(String token) {
        return token.split("\\|")[0];
    }

    public String extractRole(String token) {
        return token.split("\\|")[1];
    }

    public Long extractUserId(String token) {
        return Long.parseLong(token.split("\\|")[2]);
    }
}
