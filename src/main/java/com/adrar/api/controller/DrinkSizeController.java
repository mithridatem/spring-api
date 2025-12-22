package com.adrar.api.controller;

import com.adrar.api.entity.DrinkSize;
import com.adrar.api.service.DrinkSizeService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

@RestController
@AllArgsConstructor
public class DrinkSizeController {

    private DrinkSizeService drinkSizeService;

    @GetMapping("/sizes")
    @ResponseStatus(HttpStatus.OK)
    public List<DrinkSize> getAllDrinkSize()
    {
        return drinkSizeService.getAllDrinkSize();
    }

    @GetMapping("/size/{id}")
    @ResponseStatus(HttpStatus.OK)
    public Optional<DrinkSize> getDrinkSizeById(@PathVariable Integer id)
    {
        return drinkSizeService.getDrinkSizeById(id);
    }

    @PostMapping("/size")
    @ResponseStatus(HttpStatus.CREATED)
    public DrinkSize createDrinkSize(@RequestBody DrinkSize drinkSize)
    {
        return drinkSizeService.addDrinkSize(drinkSize);
    }

    @DeleteMapping("size/{id}")
    public ResponseEntity<Map<String, String>>  deleteDrinkSize(@PathVariable Integer id)
    {
        Map<String, String>  response = new HashMap<>();
        response.put("Info", "La taille de boisson à été supprimé");
        drinkSizeService.removeDrinkSizeById(id);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }
}
