package com.example.springbootloginappdeepseek.service;

import com.example.springbootloginappdeepseek.entity.User;
import org.springframework.stereotype.Service;

import java.util.Map;
import java.util.UUID;
import java.util.concurrent.ConcurrentHashMap;

@Service
public class SessionService {
    public final Map<String, User> activeSessions = new ConcurrentHashMap<>();

    public String createSession(User user) {
        String sessionId = UUID.randomUUID().toString();
        activeSessions.put(sessionId, user);
        return sessionId;
    }

    public User getUserFromSession(String sessionId) {
        return activeSessions.get(sessionId);
    }

    public void invalidateSession(String sessionId) {
        activeSessions.remove(sessionId);
    }
}