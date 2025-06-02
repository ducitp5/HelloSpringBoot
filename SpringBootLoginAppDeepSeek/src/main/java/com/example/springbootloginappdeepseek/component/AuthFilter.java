package com.example.springbootloginappdeepseek.component;

import com.example.springbootloginappdeepseek.entity.User;
import com.example.springbootloginappdeepseek.service.SessionService;
import jakarta.servlet.*;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.io.IOException;

@Component
public class AuthFilter implements Filter {

    @Autowired
    private SessionService sessionService; // or JwtService

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
            throws IOException, ServletException {

        HttpServletRequest httpRequest = (HttpServletRequest) request;
        String path = httpRequest.getRequestURI();

        // Skip auth for login and public endpoints
        if (path.startsWith("/api/auth") || path.startsWith("/public")) {
            chain.doFilter(request, response);
            return;
        }

        String token = httpRequest.getHeader("X-Auth-Token");
        // For JWT: String token = getJwtFromHeader(httpRequest);
        User $user = sessionService.getUserFromSession(token);

        if (token == null || ($user == null)) {
            // For JWT: !jwtService.validateToken(token)
            sendErrorResponse((HttpServletResponse) response, "Unauthorized 222");
            return;
        }

        chain.doFilter(request, response);
    }

    private void sendErrorResponse(HttpServletResponse response, String message) throws IOException {
        response.setContentType("application/json");
        response.setStatus(HttpServletResponse.SC_UNAUTHORIZED);
        response.getWriter().write("{\"error\": \"" + message + "\"}");
    }

    // For JWT
    private String getJwtFromHeader(HttpServletRequest request) {
        String header = request.getHeader("Authorization");
        if (header != null && header.startsWith("Bearer ")) {
            return header.substring(7);
        }
        return null;
    }
}