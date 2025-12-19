package com.adrar.api.controller;

import com.adrar.api.exception.DrinkTypeNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import java.util.HashMap;
import java.util.Map;

@ControllerAdvice
public class AdviceDrinkTypeController {

    @ExceptionHandler(DrinkTypeNotFoundException.class)
    public ResponseEntity<Map<String, String>> handleException(RuntimeException ex)
    {
        Map<String,String> response = new HashMap<>();
        response.put("Error", ex.getMessage());
        return ResponseEntity
                .status(HttpStatus.NOT_FOUND)
                .body(response);
    }
}
