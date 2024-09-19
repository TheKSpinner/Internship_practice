package com.example.intern.product.services;

import com.example.intern.Query;
import com.example.intern.product.ProductRepository;

import com.example.intern.product.model.ProductDTO;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SearchProductService implements Query<String, List<ProductDTO>> {

    ProductRepository productRepository;

    public SearchProductService(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    @Override
    public ResponseEntity<List<ProductDTO>> execute(String name) {
        return ResponseEntity.ok(productRepository.findByNameContaining(name)
                .stream()
                .map(ProductDTO::new)
                .toList());
    }


}
