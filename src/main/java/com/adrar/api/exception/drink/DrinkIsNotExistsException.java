package com.adrar.api.exception.drink;

public class DrinkIsNotExistsException extends RuntimeException {
    public DrinkIsNotExistsException(String message) {
        super(message);
    }
}
