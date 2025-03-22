package com.example.hellospringboot.database.seeder;

import org.springframework.stereotype.Service;

@Service
public class DataSeeder {
    private final UserPostSeeder userPostSeeder;
    private final ProfileSeeder profileSeeder;

    public DataSeeder(UserPostSeeder userPostSeeder, ProfileSeeder profileSeeder) {
        this.userPostSeeder = userPostSeeder;
        this.profileSeeder = profileSeeder;
    }

    public void runSeeder() {
        userPostSeeder.runSeeder();
//        profileSeeder.runSeeder();
    }

    public void seedProfile() {

        profileSeeder.runSeeder();
    }
}
