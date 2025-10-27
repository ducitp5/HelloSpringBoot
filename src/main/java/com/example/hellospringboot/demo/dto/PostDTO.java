package com.example.hellospringboot.demo.dto;

import java.util.List;

public record PostDTO(
        Long id,
        String content,
        List<CommentDTO> comments
) {}