package com.example.hellospringboot.controller;

import com.example.hellospringboot.model.User;
import com.example.hellospringboot.service.UserService;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("/home")

public class HomeController {

    private final UserService userService;

    public HomeController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/")
    public String home() {
        return "home"; // Renders home.html
    }

    @GetMapping("/home")
    public String home(Model model) {
        model.addAttribute("name", "John");
        return "flow/index";  // Return tên của View, model sẽ tự động pass vào view
    }

    @GetMapping("/users-body")
    @ResponseBody
    public List<User> getUserList() {
        return userService.getAllUsers();
    }

    @GetMapping("/header2")
    @ResponseBody
    public String getUserInfo(@RequestHeader("User-Agent") String userAgent) {
        return "User-Agent: " + userAgent;
    }

    @GetMapping("/all-headers")
    @ResponseBody
    public Map<String, String> getAllHeaders(@RequestHeader Map<String, String> headers) {
        return headers; // Returns all headers as JSON
    }

}
