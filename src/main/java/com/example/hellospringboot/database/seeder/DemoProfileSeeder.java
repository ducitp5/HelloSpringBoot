//package com.example.hellospringboot.database.seeder;
//
//import com.example.hellospringboot.HelloSpringBootApplication;
//import com.example.hellospringboot.demo.entity.Profile;
//import com.example.hellospringboot.demo.entity.User;
//import com.example.hellospringboot.demo.repository.ProfileRepository;
//import com.example.hellospringboot.demo.repository.UserRepository;
//
//
//import com.github.javafaker.Faker;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.boot.SpringApplication;
//import org.springframework.context.ApplicationContext;
//import org.springframework.stereotype.Service;
//
//import java.util.ArrayList;
//import java.util.List;
//import java.util.Random;
//
//@Service
//public class DemoProfileSeeder {
//
//    private final UserRepository userRepository;
//    @Autowired
//    public ProfileRepository profileRepository;
//
//    public DemoProfileSeeder(UserRepository userRepository) {
//
//        this.userRepository = userRepository;
//    }
//
//    public void runSeeder() {
//        Faker faker = new Faker();
//        Random random = new Random();
//
//        // Fetch all existing users
//        List<User> users = userRepository.findAll();
//
//        List<Profile> profiles = new ArrayList<>();
//
//        int seededProfiles = 0;
//
//        for (User user : users) {
//            // Check if the user already has a profile
//            if (user.getProfile() == null) {
//                Profile profile = new Profile(
//                        faker.lorem().sentence(), // Random bio
//                        faker.internet().avatar(), // Random avatar URL
//                        user.id
//                );
//                profiles.add(profile);
//                seededProfiles++;
//            }
//        }
//
//        // Save updated users with profiles
//        profileRepository.saveAll(profiles);
//        System.out.println("Seeded profiles for " + seededProfiles + " users.");
//    }
//
//    public static void main(String[] args) {
//
//        // Initialize Spring Boot and get the application context
//        ApplicationContext context = SpringApplication.run(HelloSpringBootApplication.class, args);
//        // how get current runing app instead of create new app, to avoid conflic port
//        // Retrieve the UserPostSeeder bean from the context
//        DemoProfileSeeder seeder = context.getBean(DemoProfileSeeder.class);
//
//        // Run the seeder logic
//        seeder.runSeeder();
//
//    }
//
//}
