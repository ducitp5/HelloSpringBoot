package com.example.hellospringboot.database.seeder;

import com.example.hellospringboot.HelloSpringBootApplication;
import com.example.hellospringboot.model.Post;
import com.example.hellospringboot.model.Profile;
import com.example.hellospringboot.model.User;
import com.example.hellospringboot.repository.UserRepository;
import com.github.javafaker.Faker;
import org.springframework.boot.SpringApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

@Service
public class ProfileSeeder {

    private final UserRepository userRepository;

    public ProfileSeeder(UserRepository userRepository) {

        this.userRepository = userRepository;
    }

    public void runSeeder() {
        Faker faker = new Faker();
        Random random = new Random();

        // Fetch all existing users
        List<User> users = userRepository.findAll();
        if (users.isEmpty()) {
            System.out.println("No existing users found. Skipping profile seeding.");
            return;
        }

        int seededProfiles = 0;

        for (User user : users) {
            // Check if the user already has a profile
            if (user.getProfile() == null) {
                Profile profile = new Profile(
                        faker.lorem().sentence(), // Random bio
                        faker.internet().avatar(), // Random avatar URL
                        user
                );
                user.setProfile(profile);
                seededProfiles++;
            }
        }

        // Save updated users with profiles
        userRepository.saveAll(users);
        System.out.println("Seeded profiles for " + seededProfiles + " users.");
    }

    public static void main(String[] args) {

        // Initialize Spring Boot and get the application context
        ApplicationContext context = SpringApplication.run(HelloSpringBootApplication.class, args);
        // how get current runing app instead of create new app, to avoid conflic port
        // Retrieve the UserPostSeeder bean from the context
        ProfileSeeder seeder = context.getBean(ProfileSeeder.class);

        // Run the seeder logic
        seeder.runSeeder();

    }

}
