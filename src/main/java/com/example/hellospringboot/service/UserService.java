package com.example.hellospringboot.service;

import com.example.hellospringboot.model.User;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class UserService {

    private final List<User> users = new ArrayList<>();

    public UserService() {
        users.add(new User("John Doe", "john@example.com"));
        users.add(new User("Jane Doe", "jane@example.com"));
    }

    public List<User> getAllUsers() {
        return users;
    }

    public void addUser(User user) {
        users.add(user);
    }
}
