package com.example.hellospringboot.service;

import com.example.hellospringboot.model.User;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {

    public List<User> getAllUsers() {
        return List.of(
                new User("John Doe", 25, "john@example.com"),
                new User("Jane Doe", 22, "jane@example.com")
        );
    }
}
