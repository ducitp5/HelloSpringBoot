package com.example.springbootloginappdeepseek.component;

import com.example.springbootloginappdeepseek.entity.Permission;
import com.example.springbootloginappdeepseek.entity.Role;
import com.example.springbootloginappdeepseek.entity.User;
import com.example.springbootloginappdeepseek.repository.PermissionRepository;
import com.example.springbootloginappdeepseek.repository.RoleRepository;
import com.example.springbootloginappdeepseek.repository.UserRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.util.Set;

//@Component
public class DataInitializer implements CommandLineRunner {

    private final UserRepository userRepository;
    private final RoleRepository roleRepository;
    private final PermissionRepository permissionRepository;

    public DataInitializer(UserRepository userRepository,
                           RoleRepository roleRepository,
                           PermissionRepository permissionRepository) {
        this.userRepository = userRepository;
        this.roleRepository = roleRepository;
        this.permissionRepository = permissionRepository;
    }

    @Override
    @Transactional
    public void run(String... args) throws Exception {
        // Kiểm tra xem dữ liệu đã tồn tại chưa
        if (userRepository.count() == 0) {
            initData();
        }
    }

    private void initData() {
        // Tạo các permission
        Permission viewProfile = createPermissionIfNotFound("VIEW_PROFILE", "Xem thông tin cá nhân");
        Permission editProfile = createPermissionIfNotFound("EDIT_PROFILE", "Sửa thông tin cá nhân");
        Permission adminAccess = createPermissionIfNotFound("ADMIN_ACCESS", "Truy cập trang admin");
        Permission manageUsers = createPermissionIfNotFound("MANAGE_USERS", "Quản lý người dùng");

        // Tạo các role và gán permission
        Role userRole = createRoleIfNotFound("ROLE_USER", Set.of(viewProfile, editProfile));
        Role adminRole = createRoleIfNotFound("ROLE_ADMIN", Set.of(adminAccess, manageUsers, viewProfile, editProfile));

        // Tạo user demo
        createUserIfNotFound("user", "password123", true, Set.of(userRole));
        createUserIfNotFound("admin", "admin123", true, Set.of(adminRole));
    }

    private Permission createPermissionIfNotFound(String name, String description) {
        return permissionRepository.findByName(name)
                .orElseGet(() -> {
                    Permission permission = new Permission();
                    permission.setName(name);
                    permission.setDescription(description);
                    return permissionRepository.save(permission);
                });
    }

    private Role createRoleIfNotFound(String name, Set<Permission> permissions) {
        return roleRepository.findByName(name)
                .orElseGet(() -> {
                    Role role = new Role();
                    role.setName(name);
                    role.setPermissions(permissions);
                    return roleRepository.save(role);
                });
    }

    private void createUserIfNotFound(String username, String password, boolean enabled, Set<Role> roles) {
        if (!userRepository.existsByUsername(username)) {
            User user = new User();
            user.setUsername(username);
            user.setPassword(password); // Trong thực tế nên mã hóa password
            user.setEnabled(enabled);
            user.setRoles(roles);
            userRepository.save(user);
        }
    }
}