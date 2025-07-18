package com.example.authservice.dto;

import java.time.LocalDateTime;

public class AuthResponse {
    
    private String token;
    private String type = "Bearer";
    private String email;
    private String role;
    private LocalDateTime expiresAt;
    
    public AuthResponse() {}
    
    public AuthResponse(String token, String email, String role, LocalDateTime expiresAt) {
        this.token = token;
        this.email = email;
        this.role = role;
        this.expiresAt = expiresAt;
    }
    
    public String getToken() {
        return token;
    }
    
    public void setToken(String token) {
        this.token = token;
    }
    
    public String getType() {
        return type;
    }
    
    public void setType(String type) {
        this.type = type;
    }
    
    public String getEmail() {
        return email;
    }
    
    public void setEmail(String email) {
        this.email = email;
    }
    
    public String getRole() {
        return role;
    }
    
    public void setRole(String role) {
        this.role = role;
    }
    
    public LocalDateTime getExpiresAt() {
        return expiresAt;
    }
    
    public void setExpiresAt(LocalDateTime expiresAt) {
        this.expiresAt = expiresAt;
    }
}