package com.example.hellospringboot.demo.repository;

import com.example.hellospringboot.demo.entity.Profile;
import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository("DemoProfileRepository")
public interface ProfileRepository extends JpaRepository<Profile, Long> {

    @EntityGraph(attributePaths = {"posts", "posts.comments", "posts.comments.user"})
    Profile findById(long id_profile);
}