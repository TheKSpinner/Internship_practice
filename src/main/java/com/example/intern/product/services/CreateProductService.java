package com.example.intern.product.services;

import com.example.intern.Command;

import com.example.intern.product.model.Product;
import com.example.intern.product.model.ProductDTO;
import com.example.intern.product.ProductRepository;
import com.example.intern.product.validators.ProductValidator;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;


@Service
public class CreateProductService implements Command<Product, ProductDTO> {

    private final ProductRepository productRepository;

    public CreateProductService(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    @Override
    public ResponseEntity<ProductDTO> execute(Product product) {
        ProductValidator.execute(product);
        Product savedProduct = productRepository.save(product);
        return ResponseEntity.status(HttpStatus.CREATED).body(new ProductDTO(savedProduct));
    }


}
