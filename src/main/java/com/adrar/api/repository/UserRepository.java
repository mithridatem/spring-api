package com.adrar.api.repository;

import com.adrar.api.entity.filter.NameOnly;
import com.adrar.api.entity.User;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface UserRepository extends CrudRepository<User, Integer> {
    public boolean existsByEmail(String email);
    public Optional<User> findByEmail(String email);
    public List<NameOnly> findAllBy();
}
