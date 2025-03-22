package com.example.hellospringboot.database.seeder;

import org.springframework.stereotype.Service;

@Service
public class DataSeeder {
    private final UserPostSeeder userPostSeeder;

    public DataSeeder(UserPostSeeder userPostSeeder) {
        this.userPostSeeder = userPostSeeder;
    }

    public void runSeeder() {
        userPostSeeder.runSeeder();
    }
}
