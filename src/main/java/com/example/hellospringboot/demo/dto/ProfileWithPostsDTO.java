package com.example.hellospringboot.demo.dto;

import java.util.List;

public record ProfileWithPostsDTO(
        Long idProfile,
        String bio,
        String avatarUrl,
        Long userId,
        String userName,
        String userEmail,
        List<PostDTO> posts
) {}
