package com.example.hellospringboot;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller  // Use @Controller instead of @RestController
public class WelcomeController {

    @GetMapping("/")
    public String welcome() {
        return "index"; // Spring Boot will look for templates/index.html
    }
}
