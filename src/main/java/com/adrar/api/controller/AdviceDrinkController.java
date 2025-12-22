package com.adrar.api.controller;

import com.adrar.api.exception.drink.NoDrinkFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.HashMap;
import java.util.Map;

@RestControllerAdvice
public class AdviceDrinkController {

    @ExceptionHandler(NoDrinkFoundException.class)
    public ResponseEntity<Map<String, String>> handleNoDrinkFoundException(NoDrinkFoundException ex)
    {
        Map<String, String> response = new HashMap<>();
        response.put("Error", ex.getMessage());
        return ResponseEntity
                .status(HttpStatus.ACCEPTED)
                .body(response);
    }
}
