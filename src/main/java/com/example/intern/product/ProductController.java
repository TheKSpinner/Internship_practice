package com.example.intern.product;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class ProductController {


    private final CreateProductService createProductService;
    private final DeleteProductService deleteProductService;
    private final UpdateProductService updateProductService;
    private final GetProductService getProductService;
    public ProductController(CreateProductService createProductService,
                             DeleteProductService deleteProductService,
                             UpdateProductService updateProductService,
                             GetProductService getProductService) {
        this.createProductService = createProductService;
        this.deleteProductService = deleteProductService;
        this.updateProductService = updateProductService;
        this.getProductService = getProductService;
    }


    @PostMapping
    public ResponseEntity<String> createProduct() {
        return createProductService.execute(null);
    }
    @GetMapping
    public ResponseEntity<String> getProduct() {
        return getProductService.execute(null);
    }
    @PutMapping
    public ResponseEntity<String> putProduct() {
        return updateProductService.execute(null);
    }
    @DeleteMapping
    public ResponseEntity<String> deleteProduct() {
        return deleteProductService.execute(null);
    }
}
