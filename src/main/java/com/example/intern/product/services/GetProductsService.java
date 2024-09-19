package com.example.intern.product.services;

import com.example.intern.Query;
import com.example.intern.product.model.Product;
import com.example.intern.product.ProductRepository;
import com.example.intern.product.model.ProductDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class GetProductsService implements Query<Void,List<ProductDTO>> {

    private final ProductRepository productRepository;

    public GetProductsService(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    @Override
    public ResponseEntity<List<ProductDTO>> execute(Void input ) {
        List<Product> products=productRepository.findAll();
        List<ProductDTO>productDTOS=products.stream().map(ProductDTO::new).toList();

        return ResponseEntity.status(HttpStatus.OK).body(productDTOS);
    }
}
