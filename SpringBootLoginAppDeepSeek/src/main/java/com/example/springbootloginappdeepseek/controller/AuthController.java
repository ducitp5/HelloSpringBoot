package com.example.springbootloginappdeepseek.controller;

import com.example.springbootloginappdeepseek.dto.LoginRequest;
import com.example.springbootloginappdeepseek.entity.Role;
import com.example.springbootloginappdeepseek.entity.User;
import com.example.springbootloginappdeepseek.service.AuthService;
import com.example.springbootloginappdeepseek.service.SessionService;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Map;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/auth")
public class AuthController {

    @Autowired
    private AuthService authService;

    @Autowired
    private SessionService sessionService; // or JwtService

    @PostMapping("/login")
    public ResponseEntity<?> login(@RequestBody LoginRequest loginRequest, HttpServletResponse response) {
        User user = authService.authenticate(loginRequest);

        if (user != null) {
            // Session-based
            String sessionId = sessionService.createSession(user);
            response.setHeader("X-Auth-Token", sessionId);

            // Or JWT-based
            // String token = jwtService.generateToken(user);
            // response.setHeader("Authorization", "Bearer " + token);

            return ResponseEntity.ok()
                    .body(Map.of(
                            "sessionService", sessionService.activeSessions,
                            "X-Auth-Token", sessionId,
                            "message", "Login successful",
                            "user", user.getUsername(),
                            "roles", user.getRoles().stream()
                                    .map(Role::getName)
                                    .collect(Collectors.toList())
                    ));
        }

        return ResponseEntity.status(HttpStatus.UNAUTHORIZED)
                .body(Map.of("error", "Invalid username or password"));
    }

    @PostMapping("/logout")
    public ResponseEntity<?> logout(@RequestHeader("X-Auth-Token") String sessionId) {
        sessionService.invalidateSession(sessionId);
        return ResponseEntity.ok(Map.of("message", "Logout successful"));
    }
}
