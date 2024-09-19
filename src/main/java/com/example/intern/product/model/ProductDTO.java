package com.example.intern.product.model;
import lombok.Data;
@Data
public class ProductDTO {
    private int id;
    private String name;
    private String description;

    public ProductDTO(Product product){
        id= product.getId();
        name=product.getName();
        description=product.getDescription();
    }
}
