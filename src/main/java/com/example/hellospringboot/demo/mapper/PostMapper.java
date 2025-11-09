package com.example.hellospringboot.demo.mapper;

import com.example.hellospringboot.demo.dto.CommentDTO;
import com.example.hellospringboot.demo.dto.PostDTO;
import com.example.hellospringboot.demo.entity.Comment;
import com.example.hellospringboot.demo.entity.Post;
import com.example.hellospringboot.demo.entity.User;

import java.util.List;
import java.util.stream.Collectors;

public class PostMapper {

    public static PostDTO toBasicDTO(Post post) {

        List<Comment> comments = post.getComments();

        return new PostDTO(
                post.getId(),
                post.getContent(),
                comments.stream()
                        .map(c -> new CommentDTO(c.getId(), c.getContent()))
                        .collect(Collectors.toList())
        );
    }

    public static PostDTO toDTOwithUserId(Post post) {
        User user = post.getAutorUser();
        List<Comment> comments = post.getComments();

        return new PostDTO(
                post.getId(),
                post.getContent(),
                user.getId(),
                comments.stream()
                        .map(c -> new CommentDTO(c.getId(), c.getContent()))
                        .collect(Collectors.toList())
        );
    }

}