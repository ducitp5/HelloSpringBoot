package com.example.springbootmultidatasources.db2.controller;

import com.example.springbootmultidatasources.db1.model.Product;
import com.example.springbootmultidatasources.db1.repository.ProductRepo;
import com.example.springbootmultidatasources.db2.model.User;
import com.example.springbootmultidatasources.db2.repository.UserRepository;
import com.example.springbootmultidatasources.db2.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api")
public class UserController {

    @Autowired
    private UserRepository userRepository;
    @Autowired
    private ProductRepo productRepository;

    @Autowired
    private UserService userService;

    // Endpoint to save a user
    @PostMapping("/saveUser")
    public ResponseEntity<User> save(@RequestBody User user){
        User myuser = userService.saveUser(user);
        return new ResponseEntity<>(myuser, HttpStatus.OK);
    }

    @GetMapping("/")
    @ResponseBody
    public Map<String, Object>  home(Model model) {
        List<User> users = userRepository.findAll();
        List<Product> products = productRepository.findAll();

        Map<String, Object> data = new HashMap<>();
        data.put("users", users);
        data.put("products", products);
        return data;
    }
}