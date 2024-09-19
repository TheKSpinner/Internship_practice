package com.example.intern.exceptions;

import lombok.Getter;

@Getter
public enum ErrorMessages {

    PRODUCT_NOT_FOUND("Product Not Found"),
    DESCRIPTION_LENGTH("Description must be at least "),
    PRICE_CANNOT_BE_NEGATIVE("Price cannot be negative"),
    NAME_REQUIRED("Name cannot be null");


    private final String message;
    ErrorMessages(String message) {
        this.message=message;
    }

}
