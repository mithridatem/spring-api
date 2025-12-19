package com.adrar.api.controller;

import com.adrar.api.entity.DrinkType;
import com.adrar.api.service.DrinkTypeService;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

@RestController
@AllArgsConstructor
public class DrinkTypeController {

    private DrinkTypeService drinkTypeService;

    @GetMapping("/types")
    @ResponseStatus(HttpStatus.OK)
    public List<DrinkType> getDrinkTypes()
    {
        return drinkTypeService.getAllDrinkTypes();
    }

    @GetMapping("/type/{id}")
    @ResponseStatus(HttpStatus.OK)
    public Optional<DrinkType> getDrinkTypeById(@PathVariable Integer id)
    {
        return drinkTypeService.getDrinkTypeById(id);
    }

    @PostMapping("/type")
    @ResponseStatus(HttpStatus.CREATED)
    public DrinkType createType(@RequestBody DrinkType drinkType)
    {
        return drinkTypeService.addDrinkType(drinkType);
    }

    @DeleteMapping("/type/{id}")
    public ResponseEntity<Map<String, String>>  deleteTypeById(@PathVariable Integer id)
    {
        Map<String, String> response = new HashMap<>();
        response.put("Info", "type supprimé");
        drinkTypeService.removeDrinkTypeById(id);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }
}
