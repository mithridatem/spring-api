package com.adrar.api.repository;

import com.adrar.api.entity.DrinkType;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DrinkTypeRepository extends CrudRepository<DrinkType, Integer> {
    public boolean existsByName(String name);
}
