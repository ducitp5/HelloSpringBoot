package com.example.hellospringboot.demo.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import java.util.List;

@Entity(name = "postDemo")
@Getter
@Setter
@Table(name = "posts")
public class Post {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    //    @Transient
    public Long getUserId() {
        return autorUser.getId();
    }

    @Column(nullable = false, columnDefinition = "TEXT", name = "content")
    private String contentt;

    @JsonProperty("post_content")
    public String getContent() {
        return this.contentt;
    }

    @ManyToOne()
    @JsonBackReference
    @JoinColumn(name = "user_id", referencedColumnName = "id", nullable = false)
    User autorUser;

    @OneToMany(mappedBy = "post")
    List<Comment> comments;


}