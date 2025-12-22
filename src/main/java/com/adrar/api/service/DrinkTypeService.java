package com.adrar.api.service;

import com.adrar.api.entity.DrinkType;
import com.adrar.api.exception.type.DrinkTypeAllReadyExistsException;
import com.adrar.api.exception.type.DrinkTypeIsNotExistsException;
import com.adrar.api.exception.type.DrinkTypesNotFoundException;
import com.adrar.api.repository.DrinkTypeRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class DrinkTypeService {

    private DrinkTypeRepository drinkTypeRepository;

    //Ajouter un type
    public DrinkType addDrinkType(DrinkType drinkType)
    {
        //tester si le type existe déja
        if (drinkTypeRepository.existsByName(drinkType.getName())) {
            throw new DrinkTypeAllReadyExistsException("Le type avec le name suivant : " + drinkType.getName() +" existe déja");
        }
        return drinkTypeRepository.save(drinkType);
    }

    //afficher tous,
    public List<DrinkType> getAllDrinkTypes()
    {
        if (drinkTypeRepository.count() == 0) {
            throw new DrinkTypesNotFoundException("La liste des types est vide");
        }
        return (List<DrinkType>) drinkTypeRepository.findAll();
    }

    //afficher un (id ou attribut),
    public Optional<DrinkType> getDrinkTypeById(int id)
    {

        return Optional
                .of(drinkTypeRepository
                        .findById(id)
                        .orElseThrow(()-> new DrinkTypeIsNotExistsException(
                                "Le type avec le id suivant : " + id + " n'existe pas"
                        )
                    )
                );
    }
    //supprimer un (id)
    public void removeDrinkTypeById(int id)
    {
        drinkTypeRepository.deleteById(id);
    }
}
