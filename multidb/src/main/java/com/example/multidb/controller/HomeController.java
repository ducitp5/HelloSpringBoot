package com.example.multidb.controller;

import com.example.multidb.model.primary.User;
import com.example.multidb.model.secondary.Product;
import com.example.multidb.repo.primary.UserRepository;
import com.example.multidb.repo.secondary.ProductRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Controller
public class HomeController {

    private final UserRepository userRepository;
    private final ProductRepository productRepository;

    public HomeController(UserRepository userRepository, ProductRepository productRepository) {
        this.userRepository = userRepository;
        this.productRepository = productRepository;
    }

    @GetMapping("/")
    public String home(Model model) {
        List<User> users = userRepository.findAll();
        List<Product> products = productRepository.findAll();

        model.addAttribute("users", users);
        model.addAttribute("products", products);
        return "index"; // corresponds to src/main/resources/templates/index.html
    }
}
