package com.adrar.api.repository;

import com.adrar.api.entity.Drink;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DrinkRepository extends CrudRepository<Drink, Integer> {
}
