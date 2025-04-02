package com.example.hellospringboot.demo.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Entity(name = "userDemo")
@Getter
@Setter
@Table(name = "users")

public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public Long id;

    public String name;
    public String email;

//    public Long getId() { return id; }
//    public String getName() { return name; }
//    public String getEmail() { return email; }
//    public Profile getProfile() { return profile; }

//    @OneToMany(mappedBy = "autorUser", cascade = CascadeType.ALL)
    @JsonIgnoreProperties("autorUser") // Avoid recursion
    @OneToMany
    @JoinColumn(name = "user_id", referencedColumnName = "id") // This tells JPA to join on "user_id" from posts

    List<Post> posts;

}