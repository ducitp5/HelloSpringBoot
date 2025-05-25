package com.example.multidb.model.secondary;

import jakarta.persistence.*;

@Entity
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    String name;
    @Column(name = "price")
    String user_name;

    public String getName() {
        return name;
    }

    public String getUser_name() {
        return user_name;
    }
}
