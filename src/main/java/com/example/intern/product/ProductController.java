package com.example.intern.product;



import com.example.intern.product.model.Product;
import com.example.intern.product.model.ProductDTO;
import com.example.intern.product.model.UpdateProductCommand;
import com.example.intern.product.services.*;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class ProductController {


    private final CreateProductService createProductService;
    private final DeleteProductService deleteProductService;
    private final UpdateProductService updateProductService;
    private final GetProductsService getProductsService;
    private final GetProductService getProductService;
    private final SearchProductService searchProductService;
    public ProductController(CreateProductService createProductService,
                             DeleteProductService deleteProductService,
                             UpdateProductService updateProductService,
                             GetProductsService getProductsService,
                             GetProductService getProductService,
                             SearchProductService searchProductService) {
        this.createProductService = createProductService;
        this.deleteProductService = deleteProductService;
        this.updateProductService = updateProductService;
        this.getProductsService = getProductsService;
        this.getProductService=getProductService;
        this.searchProductService=searchProductService;
    }


    @PostMapping("/product")
    public ResponseEntity<ProductDTO> createProduct(@RequestBody Product product) {
        return createProductService.execute(product);
    }
    @GetMapping("/product")
    public ResponseEntity<List<ProductDTO>> getProducts() {
        return getProductsService.execute(null);
    }

    @GetMapping("/product/{id}")
    public ResponseEntity<ProductDTO> getProductById(@PathVariable Integer id){
        return getProductService.execute(id);
    }


    @PutMapping("/product/{id}")
    public ResponseEntity<ProductDTO> putProduct(@PathVariable int id, @RequestBody Product product) {
        return updateProductService.execute(new UpdateProductCommand(id,product));
    }
    @DeleteMapping("/product/{id}")
    public ResponseEntity<String> deleteProduct(@PathVariable int id) {
        return deleteProductService.execute(id);
    }

    @GetMapping("/product/search")
    public ResponseEntity<List<ProductDTO>> searchProductByName(@RequestParam String name){
        return searchProductService.execute(name);
    }


}
