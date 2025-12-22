package com.adrar.api.exception.type;

public class DrinkTypeNotFoundException extends RuntimeException {
    public DrinkTypeNotFoundException() {
        super("Le type n'existe pas");
    }
}
