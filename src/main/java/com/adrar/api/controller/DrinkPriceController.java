package com.adrar.api.controller;

import com.adrar.api.dto.DrinkDTO;
import com.adrar.api.dto.DrinkDTOFr;
import com.adrar.api.entity.DrinkPrice;
import com.adrar.api.service.DrinkPriceService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Stream;


@RestController
@AllArgsConstructor
public class DrinkPriceController {

    private DrinkPriceService drinkPriceService;

    @GetMapping("/prices")
    @ResponseStatus(HttpStatus.OK)
    public List<DrinkPrice> getDrinkPrices()
    {
        return drinkPriceService.getAllDrinkPrice();
    }

    @GetMapping("/price/{id}")
    @ResponseStatus(HttpStatus.OK)
    public Optional<DrinkPrice> getDrinkPrice(@PathVariable Integer id)
    {
        return drinkPriceService.getDrinkPriceById(id);
    }

    @PostMapping("/price")
    @ResponseStatus(HttpStatus.CREATED)
    public DrinkPrice createDrinkPrice(@RequestBody DrinkPrice drinkPrice)
    {
        return drinkPriceService.addDrinkPrice(drinkPrice);
    }

    @DeleteMapping("/price/{id}")
    public ResponseEntity<Map<String, String>> deleteDrinkPriceById(@PathVariable Integer id)
    {
        Map<String,String> response = new HashMap<>();
        response.put("Info","Le prix à été supprimé");
        drinkPriceService.removeDrinkPriceById(id);
        return new ResponseEntity<>(response,HttpStatus.OK);
    }
    
    @GetMapping("/price/dto/{id}")
    @ResponseStatus(HttpStatus.OK)
    public DrinkDTO getDrinkDTOById(@PathVariable Integer id) {
        return drinkPriceService.getDTOById(id);
    }

    @GetMapping("/price/dtofr/{id}")
    @ResponseStatus(HttpStatus.OK)
    public Stream<DrinkDTOFr> getDrinkDTOFrById(@PathVariable Integer id) {
        return drinkPriceService.getDrinkDTOFrById(id);
    }
}
