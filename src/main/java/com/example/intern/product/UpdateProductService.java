package com.example.intern.product;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public class UpdateProductService implements Command<Void,String>{


    @Override
    public ResponseEntity<String> execute(Void I) {
        return ResponseEntity.status(HttpStatus.OK).body("Product updated");
    }
}
