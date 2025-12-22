package com.adrar.api.service;

import com.adrar.api.dto.DrinkDTO;
import com.adrar.api.dto.DrinkDTOFr;
import com.adrar.api.dto.DrinkToDrinkDTOWrapper;
import com.adrar.api.entity.DrinkPrice;
import com.adrar.api.repository.DrinkPriceRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Stream;

@Service
@AllArgsConstructor
public class DrinkPriceService {

    private DrinkPriceRepository drinkPriceRepository;

    //ajout,
    public DrinkPrice addDrinkPrice(DrinkPrice drinkPrice)
    {
        //Récupération de tous les prix qui match la valeur
        List<DrinkPrice> drinkPrices = drinkPriceRepository.findAllByPrice(drinkPrice.getPrice());

        //Itération pour vérifier si doublon
        drinkPrices.stream().forEach(dp -> {
           if (dp.getDrink()
                   .getName()
                   .equals(drinkPrice.getDrink()
                           .getName()) &&
                   dp.getDrinkSize()
                           .getVolume()
                           .equals(drinkPrice.getDrinkSize()
                                   .getVolume())
           ) {
               throw new RuntimeException("Le prix à déja été associé à la boisson");
           }
        });
        return drinkPriceRepository.save(drinkPrice);
    }

    //afficher tous,
    public List<DrinkPrice> getAllDrinkPrice()
    {
        if (drinkPriceRepository.count() == 0) {
            throw new RuntimeException("La liste des prix est vide");
        }
        return (List<DrinkPrice>) drinkPriceRepository.findAll();
    }

    //afficher un (id ou attribut),
    public Optional<DrinkPrice> getDrinkPriceById(Integer id)
    {
        return Optional
                .of(drinkPriceRepository
                        .findById(id)
                        .orElseThrow(RuntimeException::new)
                );
    }
    //supprimer un (id)
    public void removeDrinkPriceById(Integer id)
    {
        drinkPriceRepository.deleteById(id);
    }

    public Stream<DrinkDTO> getDrinkDTOById(Integer id)
    {
        return drinkPriceRepository
                .findById(id)
                .stream()
                .map(DrinkToDrinkDTOWrapper::drinkToDrinkDTO);
    }

    public Stream<DrinkDTOFr> getDrinkDTOFrById(Integer id)
    {
        return drinkPriceRepository
                .findById(id)
                .stream()
                .map(DrinkToDrinkDTOWrapper::drinkToDrinkDTOFr);
    }

    public DrinkDTO getDTOById(Integer id)
    {
        return DrinkToDrinkDTOWrapper
                .drinkToDrinkDTO(drinkPriceRepository
                        .findById(id)
                        .get()
                );
    }
}
