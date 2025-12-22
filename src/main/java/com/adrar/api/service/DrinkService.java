package com.adrar.api.service;

import com.adrar.api.entity.Drink;
import com.adrar.api.exception.drink.DrinkAllReadyExistsException;
import com.adrar.api.exception.drink.DrinksNotFoundException;
import com.adrar.api.repository.DrinkRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class DrinkService {

    private DrinkRepository drinkRepository;
    //ajout,
    public Drink addDrink(Drink drink) {
        if (drinkRepository.existsByName(drink.getName())) {
            throw new DrinkAllReadyExistsException("La boisson avec le name suivant : " + drink.getName() + " existe déjà");
        }
        return drinkRepository.save(drink);
    }
    //afficher tous,

    public List<Drink> getAllDrink()
    {
        if (drinkRepository.count() == 0) {
            throw new DrinksNotFoundException("La liste des boissons est vide");
        }
        return (List<Drink>) drinkRepository.findAll();
    }

    //afficher un (id ou attribut),
    public Optional<Drink> getDrinkById(Integer id)
    {
        return Optional
                .of(drinkRepository
                        .findById(id)
                        .orElseThrow(
                                ()-> new DrinksNotFoundException("La boisson avec id :" + id +  " n'existe pas")
                        )
                );
    }
    //afficher une boisson par son name
    public Optional<Drink> getDrinkByName(String name)
    {
       return Optional
               .ofNullable(drinkRepository
                       .findByName(name)
                       .orElseThrow(
                               ()-> new DrinksNotFoundException("La boisson avec le name :" + name +  " n'existe pas")
                       )
               );
    }
    //supprimer un (id)
    public void removeDrinkById(Integer id)
    {
        drinkRepository.deleteById(id);
    }
}
