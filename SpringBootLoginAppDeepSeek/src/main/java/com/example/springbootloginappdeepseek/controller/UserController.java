package com.example.springbootloginappdeepseek.controller;

import com.example.springbootloginappdeepseek.component.RequiredPermission;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/user")
public class UserController {

    @GetMapping("/profile")
    @RequiredPermission(value = "VIEW_PROFILE", name = "Duc")
    public String userProfile() {
        return "User Profile";
    }
}
