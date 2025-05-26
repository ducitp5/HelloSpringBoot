package com.example.springbootmultidatasources.db1.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

// Entity class for Product
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "product")
public class Product {

    @Id
    @Column(name="id")
    private int productId;

    private String name;
    private Integer price;

    public int getPrice() {
        return price != null ? price : 0; // default to 0 if null
    }

}