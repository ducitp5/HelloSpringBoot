package com.example.springbootloginappdeepseek.component;

import com.example.springbootloginappdeepseek.service.AuthService;
import com.example.springbootloginappdeepseek.service.SessionService;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.HandlerInterceptor;

@Component
public class PermissionInterceptor implements HandlerInterceptor {

    @Autowired
    private AuthService authService;
    @Autowired
    private SessionService sessionService;

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        if (handler instanceof HandlerMethod) {
            HandlerMethod handlerMethod = (HandlerMethod) handler;

            // Kiểm tra annotation trên method
            RequiredPermission methodAnnotation = handlerMethod.getMethodAnnotation(RequiredPermission.class);

            // Kiểm tra annotation trên class
            RequiredPermission classAnnotation = handlerMethod.getBeanType().getAnnotation(RequiredPermission.class);

            String requiredPermission = null;
            if (methodAnnotation != null) {
                requiredPermission = methodAnnotation.value();
            } else if (classAnnotation != null) {
                requiredPermission = classAnnotation.value();
            }

            if (requiredPermission != null) {
                String token = request.getHeader("X-Auth-Token"); // Hoặc lấy từ session/token

                String username = sessionService.getUserFromSession(token).getUsername();

                if (username == null || !authService.hasPermission(username, requiredPermission)) {
                    response.sendError(HttpServletResponse.SC_FORBIDDEN, "Access Denied");
//                    return true;
                }
            }
        }
        return true;
    }
}