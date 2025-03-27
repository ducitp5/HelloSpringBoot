package com.example.hellospringboot.demo.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity(name = "demoProfile")
@Getter
@Setter
@Table(name = "demo_profiles")
public class Profile {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_profile")
    private Long idProfile;

    private String bio;
    private String avatarUrl;

    @Column(name = "user_id", insertable = false, updatable = false)
    private Long user_id; // Keep this for constructor

    @OneToOne
    @JoinColumn(name = "user_id", referencedColumnName = "id")
    private User user;

    public Profile() {}

    public Profile(String bio, String avatarUrl, Long user_id) {
        this.bio = bio;
        this.avatarUrl = avatarUrl;
        this.user_id = user_id;
    }
}
