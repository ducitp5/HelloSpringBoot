package com.example.hellospringboot.demo.service;

import com.example.hellospringboot.demo.dto.ProfileBasicDTO;
import com.example.hellospringboot.demo.dto.ProfileWithPostsDTO;
import com.example.hellospringboot.demo.entity.Profile;
import com.example.hellospringboot.demo.entity.User;
import com.example.hellospringboot.demo.mapper.ProfileMapper;
import com.example.hellospringboot.demo.repository.ProfileRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service("profileServiceDemo")
public class ProfileService {

    @Autowired
    private ProfileRepository profileRepository;

    public List<Profile> getAllProfilesWithRelations() {
        return profileRepository.findAll();
    }

    // Default: fetch only user
    public Optional<Profile> getProfileWithRelations(Long id) {
        return profileRepository.findByidProfile(id); // This only fetches user, not posts
    }

    public Optional<Profile> getProfileWithPosts(Long id) {
        return profileRepository.findWithPostsByidProfile(id);
    }

    // Only user info
    public ProfileBasicDTO getDtoProfileWithRelations(Long id) {
        Profile profile = profileRepository.findByidProfile(id)
                .orElseThrow();
        return ProfileMapper.toBasicDTO(profile);
    }

    // User + Posts + Comments
    public ProfileWithPostsDTO getDtoProfileWithPosts(Long id) {
        Profile profile = profileRepository.findWithPostsByidProfile(id)
                .orElseThrow();
        return ProfileMapper.toWithPostsDTO(profile);
    }

    public List<ProfileBasicDTO> getDtoAllProfilesWithRelations() {
        return profileRepository.findAll()
                .stream()
                .map(ProfileMapper::toBasicDTO)
                .toList();
    }
}