package com.example.springbootloginappdeepseek.controller;

import com.example.springbootloginappdeepseek.entity.Permission;
import com.example.springbootloginappdeepseek.entity.Role;
import com.example.springbootloginappdeepseek.entity.User;
import com.example.springbootloginappdeepseek.repository.PermissionRepository;
import com.example.springbootloginappdeepseek.repository.RoleRepository;
import com.example.springbootloginappdeepseek.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/test")
public class TestController {

    @Autowired
    private UserRepository userRepository;
    @Autowired
    private RoleRepository roleRepository;
    @Autowired
    private PermissionRepository permissionRepository;

    @GetMapping("/users")
    public List<User> getAllUsers() {
        return userRepository.findAll();
    }

    @GetMapping("/roles")
    public List<Role> getAllRoles() {
        return roleRepository.findAll();
    }

    @GetMapping("/permissions")
    public List<Permission> getAllPermissions() {
        return permissionRepository.findAll();
    }
}