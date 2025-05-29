package com.example.springbootloginappdeepseek.service;

import com.example.springbootloginappdeepseek.entity.Permission;
import com.example.springbootloginappdeepseek.entity.Role;
import com.example.springbootloginappdeepseek.entity.User;
import com.example.springbootloginappdeepseek.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class AuthService {

    @Autowired
    private UserRepository userRepository;

    public boolean authenticate(String username, String password) {
        Optional<User> userOpt = userRepository.findByUsername(username);
        if (userOpt.isPresent()) {
            User user = userOpt.get();
            // Trong thực tế, bạn nên sử dụng BCrypt để mã hóa và so sánh mật khẩu
            return user.getPassword().equals(password) && user.isEnabled();
        }
        return false;
    }

    public boolean hasPermission(String username, String permissionName) {
        Optional<User> userOpt = userRepository.findByUsername(username);
        if (userOpt.isPresent()) {
            User user = userOpt.get();
            for (Role role : user.getRoles()) {
                for (Permission permission : role.getPermissions()) {
                    if (permission.getName().equals(permissionName)) {
                        return true;
                    }
                }
            }
        }
        return false;
    }
}