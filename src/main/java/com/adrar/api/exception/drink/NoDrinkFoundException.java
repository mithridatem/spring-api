package com.adrar.api.exception.drink;

public class NoDrinkFoundException extends RuntimeException {
    public NoDrinkFoundException(String message) {
        super(message);
    }
}
