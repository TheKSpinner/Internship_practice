package com.example.intern.product.services;

import com.example.intern.Query;
import com.example.intern.exceptions.ProductNotFoundException;
import com.example.intern.product.ProductRepository;
import com.example.intern.product.model.Product;
import com.example.intern.product.model.ProductDTO;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.Optional;

import static org.springframework.http.HttpStatus.OK;

@Service
public class GetProductService implements Query<Integer, ProductDTO> {

    private static final Logger logger= LoggerFactory.getLogger(GetProductService.class);
    public final ProductRepository productRepository;

    public GetProductService(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    @Override
    public ResponseEntity<ProductDTO> execute(Integer input) {
        logger.info("Executing " + getClass() + "input: " + input );
        Optional<Product> product=productRepository.findById(input);
        if(product.isPresent())
        {
            return ResponseEntity.status(OK).body(new ProductDTO(product.get()));
        }
        throw new ProductNotFoundException();
    }
}
