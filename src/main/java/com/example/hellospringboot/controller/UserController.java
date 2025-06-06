package com.example.hellospringboot.controller;

import com.example.hellospringboot.model.User;
import com.example.hellospringboot.service.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("/users")
public class UserController {

    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping
    public String listUsers(Model model) {
        List<User> users = userService.getAllUsers();
        model.addAttribute("users", users);
        model.addAttribute("newUser", new User("", "")); // Empty user for form binding
        return "user"; // Renders user.html
    }

    @PostMapping
    public String addUser(@ModelAttribute User newUser) {
        userService.addUser(newUser);
        return "redirect:/users"; // Redirect back to user list
    }
}
