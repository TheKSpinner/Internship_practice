package com.example.intern.product.services;

import com.example.intern.Command;
import com.example.intern.exceptions.ProductNotFoundException;
import com.example.intern.product.ProductRepository;
import com.example.intern.product.model.Product;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class DeleteProductService implements Command<Integer,String> {

    private final ProductRepository productRepository;

    public DeleteProductService(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    @Override
    public ResponseEntity<String> execute(Integer id) {
        Optional<Product> product=productRepository.findById(id);
        if(product.isPresent())
        {
            productRepository.deleteById(id);
            return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
        }
        throw new ProductNotFoundException();
    }
}
