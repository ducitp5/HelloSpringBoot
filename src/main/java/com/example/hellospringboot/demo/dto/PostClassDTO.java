package com.example.hellospringboot.demo.dto;

import java.util.List;

import lombok.Data;

@Data
public class PostClassDTO {

    private Long id;
    private String content;
    private Long userIdtt; // optional
    private List<CommentDTO> comments;

    // Constructor without userIdtt
    public PostClassDTO(Long id, String content, List<CommentDTO> comments) {
        this.id = id;
        this.content = content;
        this.comments = comments;
    }

    // Constructor with userIdtt
    public PostClassDTO(Long id, String content, Long userIdtt, List<CommentDTO> comments) {
        this.id = id;
        this.content = content;
        this.userIdtt = userIdtt;
        this.comments = comments;
    }

}
