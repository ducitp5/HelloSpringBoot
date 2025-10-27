package com.example.hellospringboot.demo.controller;

import com.example.hellospringboot.demo.dto.ProfileBasicDTO;
import com.example.hellospringboot.demo.dto.ProfileWithPostsDTO;
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

    // Default API: returns profile with only user info
    @GetMapping("/{id}")
    public Optional<Profile> getProfileWithRelations(@PathVariable Long id) {
        return profileService.getProfileWithRelations(id);
    }

    // New API: returns profile with user + posts
    @GetMapping("/{id}/with-posts")
    public Optional<Profile> getProfileWithPosts(@PathVariable Long id) {
        return profileService.getProfileWithPosts(id);
    }

    @GetMapping("/dto")
    public List<ProfileBasicDTO> getDtoAllProfilesWithRelations() {
        return profileService.getDtoAllProfilesWithRelations();
    }

    @GetMapping("/dto/{id}")
    public ProfileBasicDTO getDtoProfileWithRelations(@PathVariable Long id) {
        return profileService.getDtoProfileWithRelations(id);
    }

    @GetMapping("/dto/{id}/with-posts")
    public ProfileWithPostsDTO getDtoProfileWithPosts(@PathVariable Long id) {
        return profileService.getDtoProfileWithPosts(id);
    }
}