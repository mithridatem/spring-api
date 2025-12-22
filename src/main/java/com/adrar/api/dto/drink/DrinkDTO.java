package com.adrar.api.dto.drink;

public record DrinkDTO(
        String name,
        Double price,
        Integer size,
        String types
) {
}
