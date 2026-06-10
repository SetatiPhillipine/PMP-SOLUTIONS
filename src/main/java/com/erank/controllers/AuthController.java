package com.erank.controllers;

import com.erank.models.User;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

public class AuthController {
    
    private Map<String, User> usersByEmail = new HashMap<>();
    private Map<String, User> usersByPhone = new HashMap<>();
    
    public boolean register(String fullName, String phoneNumber, String email, 
                            String password, String role) {
        
        if (usersByEmail.containsKey(email)) {
            System.out.println("Registration failed: Email already registered");
            return false;
        }
        
        if (usersByPhone.containsKey(phoneNumber)) {
            System.out.println("Registration failed: Phone number already registered");
            return false;
        }
        
        User newUser = new User(fullName, phoneNumber, email, role);
        newUser.setPasswordHash(hashPassword(password));
        
        usersByEmail.put(email, newUser);
        usersByPhone.put(phoneNumber, newUser);
        
        System.out.println("Registration successful for: " + email + " (Role: " + role + ")");
        System.out.println("User ID: " + newUser.getUserId());
        
        return true;
    }
    
    public User login(String identifier, String password) {
        User user = usersByEmail.get(identifier);
        if (user == null) {
            user = usersByPhone.get(identifier);
        }
        
        if (user == null) {
            System.out.println("Login failed: User not found - " + identifier);
            return null;
        }
        
        if (!user.getAccountStatus().equals("active")) {
            System.out.println("Login failed: Account " + user.getAccountStatus() + " - " + identifier);
            return null;
        }
        
        if (!verifyPassword(password, user.getPasswordHash())) {
            System.out.println("Login failed: Invalid password for - " + identifier);
            return null;
        }
        
        user.setLastLogin(java.time.LocalDateTime.now());
        
        System.out.println("Login successful: " + user.getEmail() + " (Role: " + user.getRole() + ")");
        return user;
    }
    
    public String getDashboardForRole(User user) {
        switch (user.getRole()) {
            case "driver":
                return "DRIVER_DASHBOARD";
            case "passenger":
                return "PASSENGER_DASHBOARD";
            case "admin":
                return "ADMIN_DASHBOARD";
            default:
                return "UNKNOWN_ROLE";
        }
    }
    
    private String hashPassword(String plainPassword) {
        return "hashed_" + plainPassword;
    }
    
    private boolean verifyPassword(String plainPassword, String hashedPassword) {
        return hashedPassword.equals("hashed_" + plainPassword);
    }
}
