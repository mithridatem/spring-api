package com.adrar.api.repository;

import com.adrar.api.entity.Role;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface RoleRepository extends JpaRepository<Role, Integer> {
    public Optional<Role> findByName(String name);
}
