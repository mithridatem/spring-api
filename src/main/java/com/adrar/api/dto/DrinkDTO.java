package com.adrar.api.dto;

public record DrinkDTO(
        String name,
        Double price,
        Integer size,
        String types
) {
}
