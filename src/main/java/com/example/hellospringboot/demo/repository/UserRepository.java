package com.example.hellospringboot.demo.repository;

import com.example.hellospringboot.demo.entity.User;
import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository("UserRepository")
public interface UserRepository extends JpaRepository<User, Long> {

    @EntityGraph(attributePaths = {"posts", "posts.comments", "posts.comments.user"})
    User findById(long id);
}