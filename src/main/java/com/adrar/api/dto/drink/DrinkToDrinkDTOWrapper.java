package com.adrar.api.dto.drink;

import com.adrar.api.entity.DrinkPrice;
import com.adrar.api.entity.DrinkType;

import java.util.Arrays;

public class DrinkToDrinkDTOWrapper {
    public static DrinkDTO drinkToDrinkDTO(DrinkPrice drinkPrice)
    {
        return new DrinkDTO(
             drinkPrice.getDrink().getName(),
                drinkPrice.getPrice(),
                drinkPrice.getDrinkSize().getVolume(),
                drinkPrice.getDrink().getDrinkTypes().toString()
        );
    }


    public static DrinkDTOFr drinkToDrinkDTOFr(DrinkPrice drinkPrice)
    {
        return new DrinkDTOFr(
                drinkPrice.getDrink().getName(),
                drinkPrice.getPrice(),
                drinkPrice.getDrinkSize().getVolume(),
                Arrays.toString(drinkPrice
                        .getDrink()
                        .getDrinkTypes()
                        .toArray(new DrinkType[0]))
        );
    }

}
