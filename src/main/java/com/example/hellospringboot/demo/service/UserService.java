package com.example.hellospringboot.demo.service;

import com.example.hellospringboot.demo.entity.User;
import com.example.hellospringboot.demo.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service("userServiceDemo")
public class UserService {

    @Autowired
    private UserRepository userRepository;

    public Optional<User> getUserWithRelations(Long id) {
        return userRepository.findById(id);
    }

    public List<User> getAllUsersWithRelations() {
        return userRepository.findAll();
    }
}