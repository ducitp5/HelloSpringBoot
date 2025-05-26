package com.example.multidb.repo.secondary;

import com.example.multidb.model.secondary.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository<Product, Long> {}
