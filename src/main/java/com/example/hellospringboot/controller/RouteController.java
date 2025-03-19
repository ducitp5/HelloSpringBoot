package com.example.hellospringboot.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.mvc.method.RequestMappingInfo;
import org.springframework.web.servlet.mvc.method.annotation.RequestMappingHandlerMapping;

import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api")
public class RouteController {

    @Autowired
    private RequestMappingHandlerMapping requestMappingHandlerMapping;

    @GetMapping("/routes")
    public List<Map<String, String>> getAllRoutes() {
        Map<RequestMappingInfo, HandlerMethod> handlerMethods = requestMappingHandlerMapping.getHandlerMethods();

        return handlerMethods.entrySet().stream().map(entry -> {
            RequestMappingInfo info = entry.getKey();
            HandlerMethod method = entry.getValue();

            // Get route patterns (Spring Boot 2 & 3 support)
            Set<String> patterns = info.getPatternsCondition() != null
                    ? info.getPatternsCondition().getPatterns()
                    : (info.getPathPatternsCondition() != null
                    ? info.getPathPatternsCondition().getPatterns().stream().map(Object::toString).collect(Collectors.toSet())
                    : Set.of());

            // Get controller class & method name
            String controller = method.getBeanType().getSimpleName();
            String methodName = method.getMethod().getName();

            // Return as a map
            return Map.of(
                    "route", String.join(", ", patterns),
                    "controller", controller,
                    "method", methodName
            );
        }).collect(Collectors.toList());
    }
}
