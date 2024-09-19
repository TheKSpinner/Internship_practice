package com.example.intern.product;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class ProductController {
    @PostMapping
    public ResponseEntity<String> createProduct() {
        return ResponseEntity.status(HttpStatus.CREATED).body("Product created");
    }
    @GetMapping
    public ResponseEntity<String> getProduct() {
        return ResponseEntity.status(HttpStatus.OK).body("Got Product");
    }
    @PutMapping
    public ResponseEntity<String> putProduct() {
        return ResponseEntity.status(HttpStatus.OK).body("Product updated");
    }
    @DeleteMapping
    public ResponseEntity<String> deleteProduct() {
        return ResponseEntity.status(HttpStatus.NO_CONTENT).body("Product Deleted");
    }
}
