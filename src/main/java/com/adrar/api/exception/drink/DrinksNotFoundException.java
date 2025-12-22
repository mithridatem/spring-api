package com.adrar.api.exception.drink;

public class DrinksNotFoundException extends RuntimeException {
    public DrinksNotFoundException(String message) {
        super(message);
    }
}
