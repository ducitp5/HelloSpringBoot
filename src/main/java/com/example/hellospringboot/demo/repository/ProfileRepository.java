package com.example.hellospringboot.demo.repository;

import com.example.hellospringboot.demo.entity.Profile;
import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository("DemoProfileRepository")
public interface ProfileRepository extends JpaRepository<Profile, Long> {

    // Fetch only user (default case)
    @EntityGraph(attributePaths = {"user"})
    Optional<Profile> findByidProfile(long idProfile);
}