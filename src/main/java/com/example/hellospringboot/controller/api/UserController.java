package com.example.hellospringboot.controller.api;

import com.example.hellospringboot.model.User;
import com.example.hellospringboot.repository.UserRepository;
import com.example.hellospringboot.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController("userApiController")
@RequestMapping("/api/users")
public class UserController {

    private final UserService userService;

    @Autowired
    private UserRepository userRepository;

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

    @GetMapping("/search")
    public String searchUser(@RequestParam String name, @RequestParam(required = false) Integer age) {
        return "Searching for user: " + name + (age != null ? " with age: " + age : "");
    }

    @GetMapping("/{id}")
    public ResponseEntity<User> getUserById(@PathVariable Long id) {
        return userRepository.findById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @GetMapping("/{id}/select")
    public ResponseEntity<User> getUserWithSelectedRelationShipById(@PathVariable Long id) {
        return userRepository.findById(id)
            .map(user -> {
                User responseUser = new User(user.getName(), user.getEmail());

                responseUser.setId(user.getId()); // Ensure ID is set
                responseUser.setProfile(user.getProfile()); // Include Profile
//                responseUser.getPosts().addAll(user.getPosts()); // Include Posts

                return ResponseEntity.ok(responseUser);
            })
            .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping("/create")
    public String createUser(@RequestBody User user) {
        return "User created: " + user.getName();
    }

    @PutMapping("update/{id}")
    public String updateUser(
            @PathVariable Long id,
            @RequestParam(required = false, defaultValue = "vai tro") String role,
            @RequestBody User user
    ) {
        return "Updating user ID: " + id + " with role: " + role + " to name: " + user.getName();
    }
}
