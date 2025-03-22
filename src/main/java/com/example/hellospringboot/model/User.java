package com.example.hellospringboot.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "users")
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String email;

    public User() {}

    public User(String name, String email) {
        this.name = name;
        this.email = email;
    }

    public Long getId() { return id; }
    public String getName() { return name; }
    public String getEmail() { return email; }

    public void setId(Long id) { this.id = id; }
    public void setName(String name) { this.name = name; }
    public void setEmail(String email) { this.email = email; }

    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
//    @JsonManagedReference
    @JsonIgnoreProperties("user") // Avoid recursion
    private List<Post> posts = new ArrayList<>();

    public List<Post> getPosts() { return posts; }

    // Helper method to add a post
    public void addPost(Post post) {
        posts.add(post);
        post.setUser(this);
    }

    @OneToOne(mappedBy = "user", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
//    @JsonManagedReference
    @JsonIgnoreProperties("user") // Avoid recursion
    private Profile profile;

    public Profile getProfile() { return profile; }

    public void setProfile(Profile profile) {
        this.profile = profile;
        profile.setUser(this);
    }
}
