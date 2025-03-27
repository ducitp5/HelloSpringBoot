package com.example.hellospringboot.demo.controller;

import com.example.hellospringboot.demo.entity.Profile;
import com.example.hellospringboot.demo.entity.User;
import com.example.hellospringboot.demo.service.ProfileService;
import com.example.hellospringboot.demo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/demo/api/profile")
@Component("profileControllerDemo")
public class ProfileController {

    @Autowired
    private ProfileService profileService;

    @GetMapping
    public List<Profile> getAllProfilesWithRelations() {

        return profileService.getAllProfilesWithRelations();
    }

    @GetMapping("/{id}")
    public Optional<Profile> getProfileWithRelations(@PathVariable Long id) {

        Optional<Profile> $pro = profileService.getProfileWithRelations(id);
        return $pro;
    }
}