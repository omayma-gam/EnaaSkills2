package com.example.authservice.enums;

public enum Role {
    ADMIN("ADMIN"),
    FORMATEUR("FORMATEUR"),
    APPRENANT("APPRENANT");
    
    private final String value;
    
    Role(String value) {
        this.value = value;
    }
    
    public String getValue() {
        return value;
    }
    
    public static Role fromValue(String value) {
        for (Role role : Role.values()) {
            if (role.getValue().equals(value)) {
                return role;
            }
        }
        throw new IllegalArgumentException("Rôle invalide: " + value);
    }
}