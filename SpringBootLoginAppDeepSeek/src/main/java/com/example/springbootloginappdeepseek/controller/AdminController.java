package com.example.springbootloginappdeepseek.controller;

import com.example.springbootloginappdeepseek.component.RequiredPermission;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/admin")
@RequiredPermission("ADMIN_ACCESS")
public class AdminController {

    @GetMapping("/dashboard")
    public String adminDashboard() {
        return "Admin Dashboard";
    }

    @GetMapping("/users")
    @RequiredPermission("MANAGE_USERS")
    public String manageUsers() {
        return "Manage Users";
    }
}

