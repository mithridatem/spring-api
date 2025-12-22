package com.adrar.api.controller;

import com.adrar.api.exception.drink.DrinkAllReadyExistsException;
import com.adrar.api.exception.drink.DrinkIsNotExistsException;
import com.adrar.api.exception.drink.DrinksNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.HashMap;
import java.util.Map;

@RestControllerAdvice
public class AdviceDrinkController {

    @ExceptionHandler(DrinksNotFoundException.class)
    public ResponseEntity<Map<String, String>> handleDrinksNotFoundException(DrinksNotFoundException ex)
    {
        Map<String, String> response = new HashMap<>();
        response.put("Error", ex.getMessage());
        return ResponseEntity
                .status(HttpStatus.ACCEPTED)
                .body(response);
    }

    @ExceptionHandler(DrinkAllReadyExistsException.class)
    public ResponseEntity<Map<String, String>> handleDrinkAllReadyExistsException(DrinkAllReadyExistsException ex)
    {
        Map<String, String> response = new HashMap<>();
        response.put("Error", ex.getMessage());
        return ResponseEntity
                .status(HttpStatus.BAD_REQUEST)
                .body(response);
    }

    @ExceptionHandler(DrinkIsNotExistsException.class)
    public ResponseEntity<Map<String, String>> handleDrinkIsNotExistsException(DrinkIsNotExistsException ex)
    {
        Map<String, String> response = new HashMap<>();
        response.put("Error", ex.getMessage());
        return ResponseEntity
                .status(HttpStatus.PARTIAL_CONTENT)
                .body(response);
    }
}
