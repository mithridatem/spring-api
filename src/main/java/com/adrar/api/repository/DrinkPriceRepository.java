package com.adrar.api.repository;

import com.adrar.api.entity.DrinkPrice;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DrinkPriceRepository extends CrudRepository<DrinkPrice, Integer> {
}
