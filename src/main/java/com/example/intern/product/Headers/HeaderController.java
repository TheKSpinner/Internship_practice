package com.example.intern.product.Headers;

import com.example.intern.product.model.Product;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HeaderController {
    @GetMapping("/header")
    public String getRegionalResponse(@RequestHeader(required = false, defaultValue = "RO") String region){

        if(region.equals("RO")) return "MICI";
        return "CevaPici";
    }

    @GetMapping(value = "header/product",produces ={MediaType.APPLICATION_JSON_VALUE/*, MediaType.APPLICATION_XML_VALUE*/})
    public ResponseEntity<Product> getProduct(){
        Product product=new Product();
        product.setId(501);
        product.setName("produs mare");
        product.setDescription("Un produs foarte foarte misto");

        return ResponseEntity.ok(product);
    }
}
