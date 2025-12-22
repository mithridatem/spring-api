package com.adrar.api.service;

import com.adrar.api.entity.Drink;
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
        return drinkRepository.save(drink);
    }
    //afficher tous,

    public List<Drink> getAllDrink()
    {
        if (drinkRepository.count() == 0) {
            throw new RuntimeException("La liste des boissons est vide");
        }
        return (List<Drink>) drinkRepository.findAll();
    }

    //afficher un (id ou attribut),
    public Optional<Drink> getDrinkById(Integer id)
    {
        return Optional
                .of(drinkRepository
                        .findById(id)
                        .orElseThrow(RuntimeException::new)
                );
    }
    //afficher une boisson par son name
    public Optional<Drink> findByName(String name)
    {
       return Optional
               .ofNullable(drinkRepository
                       .findByName(name)
                       .orElseThrow(RuntimeException::new)
               );
    }
    //supprimer un (id)
    public void removeDrinkById(Integer id)
    {
        drinkRepository.deleteById(id);
    }
}
