package com.example.hellospringboot;

import com.example.hellospringboot.model.User;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class WelcomeController {

    @GetMapping("/user")
    public User getUser() {
        return new User("John Doe", "johndoe@example.com");
    }
}
