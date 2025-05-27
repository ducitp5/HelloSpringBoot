package com.example.springbootmultidatasources.db1.repository;

import com.example.springbootmultidatasources.db1.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

// Repository interface for Product
@Repository
public interface ProductRepo extends JpaRepository<Product,Integer> {

}