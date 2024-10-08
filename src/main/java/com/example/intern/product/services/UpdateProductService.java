package com.example.intern.product.services;

import com.example.intern.Command;
import com.example.intern.exceptions.ProductNotFoundException;

import com.example.intern.product.ProductRepository;
import com.example.intern.product.model.Product;
import com.example.intern.product.model.ProductDTO;
import com.example.intern.product.model.UpdateProductCommand;
import com.example.intern.product.validators.ProductValidator;

import org.slf4j.LoggerFactory;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UpdateProductService implements Command<UpdateProductCommand, ProductDTO> {



    private final ProductRepository productRepository;

    public UpdateProductService(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    @Override
    @CachePut(value="productCache",key="#command.getId()")
    public ResponseEntity<ProductDTO> execute(UpdateProductCommand command) {
        Optional<Product> productOptional=productRepository.findById(command.getId());
        ProductValidator.execute(command.getProduct());
        if(productOptional.isPresent()){
            Product product=command.getProduct();
            product.setId(command.getId());
            productRepository.save(product);
            return ResponseEntity.ok(new ProductDTO(product));
        }
        throw new ProductNotFoundException();
    }
}
