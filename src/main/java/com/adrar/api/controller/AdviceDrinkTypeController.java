package com.adrar.api.controller;

import com.adrar.api.exception.type.DrinkTypeAllReadyExistsException;
import com.adrar.api.exception.type.DrinkTypeIsNotExistsException;
import com.adrar.api.exception.type.DrinkTypesNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import java.util.HashMap;
import java.util.Map;

@ControllerAdvice
public class AdviceDrinkTypeController {

    @ExceptionHandler(DrinkTypesNotFoundException.class)
    public ResponseEntity<Map<String, String>> handleDrinkTypeNotFoundException(RuntimeException ex)
    {
        Map<String,String> response = new HashMap<>();
        response.put("Error", ex.getMessage());
        return ResponseEntity
                .status(HttpStatus.NOT_FOUND)
                .body(response);
    }

    @ExceptionHandler(DrinkTypeAllReadyExistsException.class)
    public ResponseEntity<Map<String, String>> handleDrinkTypeAllReadyExistsException(DrinkTypeAllReadyExistsException ex)
    {
        Map<String,String> response = new HashMap<>();
        response.put("Error", ex.getMessage());
        return ResponseEntity
                .status(HttpStatus.BAD_REQUEST)
                .body(response);
    }

    @ExceptionHandler(DrinkTypeIsNotExistsException.class)
    public ResponseEntity<Map<String, String>> handleDrinkTypeIsNotExistsException(DrinkTypeIsNotExistsException ex)
    {
        Map<String,String> response = new HashMap<>();
        response.put("Error", ex.getMessage());
        return ResponseEntity
                .status(HttpStatus.PARTIAL_CONTENT)
                .body(response);
    }
}
