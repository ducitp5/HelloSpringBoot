package com.example.hellospringboot.demo.repository;

import com.example.hellospringboot.demo.entity.Post;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository("DemoPostRepository")
public interface PostRepository extends JpaRepository<Post, Long> {

    Optional<Post> findByid(long idPost);

    Optional<Post> findWithCommentsByid(long idPost);

}