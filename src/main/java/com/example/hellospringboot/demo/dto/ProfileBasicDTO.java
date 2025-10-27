package com.example.hellospringboot.demo.dto;

public record ProfileBasicDTO(
        Long idProfile,
        String bio,
        String avatarUrl,
        Long userId,
        String userName,
        String userEmail
) {}