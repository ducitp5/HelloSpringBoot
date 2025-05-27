package com.example.springbootmultidatasources.db2.service;

import com.example.springbootmultidatasources.db2.model.User;
import com.example.springbootmultidatasources.db2.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    // Service method to save a user
    public User saveUser(User user) {
        return userRepository.save(user);
    }
}