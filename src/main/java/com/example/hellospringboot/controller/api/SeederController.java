package com.example.hellospringboot.controller.api;

import com.example.hellospringboot.database.seeder.DataSeeder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/seeder")
public class SeederController {
    private final DataSeeder dataSeeder;

    public SeederController(DataSeeder dataSeeder) {
        this.dataSeeder = dataSeeder;
    }

    @GetMapping("/run")
    public String runSeeder() {
        dataSeeder.runSeeder();
        return "Seeder executed successfully!";
    }

    @GetMapping("/run/profile")
    public String seedProfile() {
        dataSeeder.seedProfile();
        return "Seeder profile successfully!";
    }

    @GetMapping("/run/comment")
    public String seedComment() {
        int nbrComments = dataSeeder.seedComment();
        return nbrComments +" Seeder comment successfully!";
    }
}
