package com.example.springbootmultidatasources.db1;

import com.example.springbootmultidatasources.db1.model.Product;
import com.example.springbootmultidatasources.db1.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

// Controller class for handling product-related requests
@RestController
@RequestMapping("/product")
public class ProductController {

    @Autowired
    private ProductService productService;

    // Endpoint for saving a product
    @PostMapping("saveProduct")
    public ResponseEntity<Product> saveProduct(@RequestBody Product product){
        Product myproduct = productService.saveProduct(product);
        return new ResponseEntity<>(myproduct, HttpStatus.OK);
    }

}