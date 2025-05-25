package com.example.multidb.model.primary;

import jakarta.persistence.*;

@Entity
@Table(name="users")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    // ✅ Getter cho name
    public String getName() {
        return name;
    }

    // Setter nếu cần
    public void setName(String name) {
        this.name = name;
    }

    // Getter/Setter cho id cũng nên có
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
}