package com.adrar.api.entity;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Table(name = "drink_type")
@Data
public class DrinkType {

    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Integer id;

    @Column(nullable = false, unique = true)
    private String name;
}
