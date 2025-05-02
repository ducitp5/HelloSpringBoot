package com.example.hellospringboot.database.seeder;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DataSeeder {
    private final UserPostSeeder userPostSeeder;
    private final ProfileSeeder profileSeeder;
    @Autowired
    private  CommentSeeder commentSeeder;

    public DataSeeder(UserPostSeeder userPostSeeder, ProfileSeeder profileSeeder) {
        this.userPostSeeder = userPostSeeder;
        this.profileSeeder = profileSeeder;
    }

    public void runSeeder() {
        userPostSeeder.runSeeder();
//        profileSeeder.runSeeder();
//        commentSeeder.runSeeder();
    }

    public void seedProfile() {

        profileSeeder.runSeeder();
    }

    public int seedComment() {

        return commentSeeder.runSeeder();
    }
}
