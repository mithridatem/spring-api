package com.adrar.api.controller;

import com.adrar.api.entity.Drink;
import com.adrar.api.service.DrinkService;
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
public class DrinkController {

    private DrinkService drinkService;


    @GetMapping("/drinks")
    @ResponseStatus(HttpStatus.OK)
    public List<Drink> getDrinks()
    {
        return  drinkService.getAllDrink();
    }

    @GetMapping("/drink/{id}")
    @ResponseStatus(HttpStatus.OK)
    public Optional<Drink> getDrink(@PathVariable Integer id)
    {
        return drinkService.getDrinkById(id);
    }

    @PostMapping("/drink")
    @ResponseStatus(HttpStatus.CREATED)
    public Drink createDrink(@RequestBody Drink drink)
    {
        return drinkService.addDrink(drink);
    }

    @DeleteMapping("/drink/{id}")
    public ResponseEntity<Map<String, String>> deleteDrinkById(@PathVariable Integer id)
    {
        Map<String, String> response = new HashMap<>();
        response.put("Info", "La boisson à été supprimé");
        return new ResponseEntity<>(response, HttpStatus.ACCEPTED);
    }
}
