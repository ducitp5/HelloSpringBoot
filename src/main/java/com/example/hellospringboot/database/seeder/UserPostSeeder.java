package com.example.hellospringboot.database.seeder;

import com.example.hellospringboot.HelloSpringBootApplication;
import com.example.hellospringboot.model.Post;
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
public class UserPostSeeder {

    private final UserRepository userRepository;

    public UserPostSeeder(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public void runSeeder() {

//        userRepository.deleteAll();
        Faker faker = new Faker();
        Random random = new Random();
        List<User> users = new ArrayList<>();

        int numberOfUsers = random.nextInt(6) + 5;
        for (int i = 0; i < numberOfUsers; i++) {
            User user = new User(
                    faker.name().fullName(),
                    faker.internet().emailAddress()
            );

            int numberOfPosts = random.nextInt(5) + 1;
            for (int j = 0; j < numberOfPosts; j++) {
                user.addPost(new Post(faker.lorem().paragraph()));
            }
            users.add(user);
        }
        userRepository.saveAll(users);
        System.out.println("Seeded " + numberOfUsers + " users with posts.");
    }

    public static void main(String[] args) {

        // Initialize Spring Boot and get the application context
        ApplicationContext context = SpringApplication.run(HelloSpringBootApplication.class, args);
        // how get current runing app instead of create new app, to avoid conflic port
        // Retrieve the UserPostSeeder bean from the context
        UserPostSeeder seeder = context.getBean(UserPostSeeder.class);

        // Run the seeder logic
        seeder.runSeeder();

    }

}
