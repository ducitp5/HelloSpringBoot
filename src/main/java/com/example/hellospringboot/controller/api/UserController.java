package com.example.hellospringboot.controller.api;

import com.example.hellospringboot.model.User;
import com.example.hellospringboot.service.UserService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController("userApiController")
@RequestMapping("/api/users")
public class UserController {

    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    // Get all users
    @GetMapping
    public List<User> getAllUsers() {
        return userService.getAllUsers();
    }

    // Create new user (POST)
    @PostMapping
    public ResponseEntity<String> addUser(@RequestBody User user) {
        userService.addUser(user);
        return ResponseEntity.ok("User added successfully!");
    }

    // ✅ Update User (PUT)
    @PutMapping("/{id}")
    public ResponseEntity<String> updateUser(@PathVariable Long id, @RequestBody User updatedUser) {
        boolean isUpdated = userService.updateUser(id, updatedUser);
        return isUpdated ? ResponseEntity.ok("User updated successfully!")
                : ResponseEntity.notFound().build();
    }

    // ✅ Delete User (DELETE)
    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteUser(@PathVariable Long id) {
        boolean isDeleted = userService.deleteUser(id);
        return isDeleted ? ResponseEntity.ok("User deleted successfully!")
                : ResponseEntity.notFound().build();
    }
}
