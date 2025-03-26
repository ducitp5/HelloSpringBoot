package com.example.hellospringboot.demo.controller;

import com.example.hellospringboot.demo.entity.User;
import com.example.hellospringboot.demo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/demo/api/users")
@Component("userControllerDemo")
public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping
    public List<User> getAllUsersWithRelations() {

        return userService.getAllUsersWithRelations();
    }

    @GetMapping("/{id}")
    public Optional<User> getUserWithRelationships(@PathVariable Long id) {

        return userService.getUserWithRelations(id);
    }
}