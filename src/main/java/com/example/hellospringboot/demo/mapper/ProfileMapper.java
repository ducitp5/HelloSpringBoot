package com.example.hellospringboot.demo.mapper;

import com.example.hellospringboot.demo.dto.*;
import com.example.hellospringboot.demo.entity.*;

import java.util.List;
import java.util.stream.Collectors;

public class ProfileMapper {

    public static ProfileBasicDTO toBasicDTO(Profile profile) {
        User user = profile.getUser();

        return new ProfileBasicDTO(
                profile.getIdProfile(),
                profile.getBio(),
                profile.getAvatarUrl(),
                user != null ? user.getId() : null,
                user != null ? user.getName() : null,
                user != null ? user.getEmail() : null
        );
    }

    public static ProfileWithPostsDTO toWithPostsDTO(Profile profile) {
        User user = profile.getUser();

        List<PostDTO> postDTOs = user.getPosts().stream().map(post ->
                new PostDTO(
                        post.getId(),
                        post.getContent(),
                        post.getComments().stream()
                                .map(c -> new CommentDTO(c.getId(), c.getContent()))
                                .collect(Collectors.toList())
                )
        ).collect(Collectors.toList());

        return new ProfileWithPostsDTO(
                profile.getIdProfile(),
                profile.getBio(),
                profile.getAvatarUrl(),
                user.getId(),
                user.getName(),
                user.getEmail(),
                postDTOs
        );
    }
}