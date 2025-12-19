package com.adrar.api.exception;

public class DrinkTypeNotFoundException extends RuntimeException {
    public DrinkTypeNotFoundException() {
        super("Le type n'existe pas");
    }
}
