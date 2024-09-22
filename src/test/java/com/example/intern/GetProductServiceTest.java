package com.example.intern;

import com.example.intern.exceptions.ProductNotFoundException;
import com.example.intern.product.ProductRepository;
import com.example.intern.product.model.Product;
import com.example.intern.product.model.ProductDTO;
import com.example.intern.product.services.GetProductService;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.http.ResponseEntity;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.*;

public class GetProductServiceTest {

    @Mock //mocking the repose of something
    private ProductRepository productRepository;

    @InjectMocks //the thing we are testing
    private GetProductService getProductService;

    @BeforeEach //thing we need before the test runs to set up properly
    public void setup() {
        //initializes the repository & the service class
        MockitoAnnotations.openMocks(this);
    }

    @Test
    public void given_produc_exists_when_get_product_service_return_product_dto() {
        //give
        Product product = new Product();
        product.setId(1);
        product.setName("Pixel");
        product.setDescription("Un telefon extraordinar de bun!!!!!!!");
        product.setPrice(20.00);

        when(productRepository.findById(1)).thenReturn(Optional.of(product));
        //when
        ResponseEntity<ProductDTO> response = getProductService.execute(1);
        //then
        assertEquals(ResponseEntity.ok(new ProductDTO(product)), response);
        //asserts the product repository was only called once
        verify(productRepository, times(1)).findById(1);

    }

    @Test
    public void given_product_does_not_exist_when_get_product_service_throw_product_not_found_exception() {
        //Given
        when(productRepository.findById(1)).thenReturn(Optional.empty());

        //When & Then
        assertThrows(ProductNotFoundException.class, () -> getProductService.execute(1));
        verify(productRepository, times(1)).findById(1);
    }

}
