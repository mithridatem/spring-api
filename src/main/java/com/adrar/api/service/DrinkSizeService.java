package com.adrar.api.service;

import com.adrar.api.entity.DrinkSize;
import com.adrar.api.repository.DrinkSizeRepository;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.ObjectProvider;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class DrinkSizeService {

    private DrinkSizeRepository drinkSizeRepository;

    //ajout,
    public DrinkSize addDrinkSize(DrinkSize drinkSize)
    {
        return drinkSizeRepository.save(drinkSize);
    }

    //afficher tous,
    public List<DrinkSize> getAllDrinkSize()
    {
        if (drinkSizeRepository.count() == 0) {
            throw  new RuntimeException("La liste des size est vide");
        }
        return (List<DrinkSize>) drinkSizeRepository.findAll();
    }
    //afficher un (id ou attribut),
    public Optional<DrinkSize> getDrinkSizeById(Integer id)
    {
        return Optional
                .of(drinkSizeRepository
                        .findById(id)
                        .orElseThrow(RuntimeException::new)
                );
    }
    //supprimer un (id)
    public void removeDrinkSizeById(Integer id)
    {
        drinkSizeRepository.deleteById(id);
    }
}
