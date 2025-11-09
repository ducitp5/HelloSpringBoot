package com.example.hellospringboot.demo.controller;

import com.example.hellospringboot.demo.dto.PostClassDTO;
import com.example.hellospringboot.demo.dto.PostDTO;
import com.example.hellospringboot.demo.entity.Post;
import com.example.hellospringboot.demo.service.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/demo/api/post")
@Component("postControllerDemo")
public class PostController {

    @Autowired
    private PostService postService;

    @GetMapping
    public List<Post> getAllPostsWithRelations() {

        return postService.getAllPostsWithRelations();
    }

    @GetMapping("/{id}")
    public Optional<Post> getPostWithRelations(@PathVariable Long id) {
        return postService.getPostWithRelations(id);
    }

    @GetMapping("/dto")
    public List<PostDTO> getDtoAllPostWithRelations() {
        return postService.getDtoAllPostWithRelations();
    }

    @GetMapping("/dto/{id}")
    public PostDTO getDtoPost(@PathVariable Long id) {
        return postService.getDtoPost(id);
    }

    @GetMapping("/dto/dtoclass")
    public List<PostClassDTO> getDtoClassAllPost() {
        return postService.getDtoClassAllPost();
    }

    @GetMapping("/dto/dtoclass/{id}")
    public PostClassDTO getPostClassDtoWithRelations(@PathVariable Long id) {
        return postService.getPostClassDtoWithRelations(id);
    }
}