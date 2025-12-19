package com.adrar.api.repository;

import com.adrar.api.entity.Drink;
import com.adrar.api.entity.DrinkPrice;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface DrinkPriceRepository extends CrudRepository<DrinkPrice, Integer> {

   public List<DrinkPrice> findAllByPrice(double price);
}
