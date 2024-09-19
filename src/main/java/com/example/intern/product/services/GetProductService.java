package com.example.intern.product.services;

import com.example.intern.Query;
import com.example.intern.product.ProductRepository;
import com.example.intern.product.model.Product;
import com.example.intern.product.model.ProductDTO;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.Optional;

import static org.springframework.http.HttpStatus.OK;

@Service
public class GetProductService implements Query<Integer, ProductDTO> {


    public final ProductRepository productRepository;

    public GetProductService(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    @Override
    public ResponseEntity<ProductDTO> execute(Integer input) {
        Optional<Product> product=productRepository.findById(input);
        if(product.isPresent())
        {
            return ResponseEntity.status(OK).body(new ProductDTO(product.get()));
        }
        //throw exception if not present
        return null;
    }
}
