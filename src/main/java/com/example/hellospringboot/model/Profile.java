package com.example.hellospringboot.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;

@Entity
@Table(name = "profiles")
public class Profile {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String bio;
    private String avatarUrl;

    @OneToOne
    @JoinColumn(name = "user_id", nullable = false)
    @JsonBackReference
    private User user;

    public Profile() {}

    public Profile(String bio, String avatarUrl, User user) {
        this.bio = bio;
        this.avatarUrl = avatarUrl;
        this.user = user;
    }

    // Getters and Setters
    public Long getId() { return id; }
    public String getBio() { return bio; }
    public String getAvatarUrl() { return avatarUrl; }
    public User getUser() { return user; }

    public void setId(Long id) { this.id = id; }
    public void setBio(String bio) { this.bio = bio; }
    public void setAvatarUrl(String avatarUrl) { this.avatarUrl = avatarUrl; }
    public void setUser(User user) { this.user = user; }
}
