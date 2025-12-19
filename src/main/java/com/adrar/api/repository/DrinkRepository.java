package com.adrar.api.repository;

import com.adrar.api.entity.Drink;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface DrinkRepository extends CrudRepository<Drink, Integer> {
    public boolean existsByName(String name);
    public Optional<Drink> findByName(String name);
}
