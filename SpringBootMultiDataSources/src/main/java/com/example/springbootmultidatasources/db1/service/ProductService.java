package com.example.springbootmultidatasources.db1.service;

import com.example.springbootmultidatasources.db1.model.Product;
import com.example.springbootmultidatasources.db1.repository.ProductRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

// Service class for product-related operations
@Service
public class ProductService {

    @Autowired
    private ProductRepo productRepo;

    // Method to save a product
    public Product saveProduct(Product product) {
        return productRepo.save(product);
    }
}