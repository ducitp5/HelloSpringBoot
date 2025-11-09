package com.example.hellospringboot.demo.dto;

import java.util.List;

public record PostDTO(
        Long id,
        String content,
        Long userIdtt,
        List<CommentDTO> comments
) {
    // Secondary constructor: no userIdtt
    public PostDTO(Long id, String content, List<CommentDTO> comments) {
        this(id, content, null, comments);
    }
}