package com.adrar.api.repository;

import com.adrar.api.entity.DrinkSize;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DrinkSizeRepository extends CrudRepository<DrinkSize, Integer> {
}
