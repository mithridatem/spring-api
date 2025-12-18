package com.adrar.api.entity;

import jakarta.persistence.*;
import lombok.Data;

import java.util.ArrayList;

@Entity
@Table(name="drink")
@Data
public class Drink {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Integer id;

    @Column(nullable = false, unique = true)
    private String name;

    @ManyToMany(cascade = {CascadeType.DETACH, CascadeType.MERGE, CascadeType.PERSIST, CascadeType.REFRESH})
    @JoinTable(name= "drink_drink_type",
            joinColumns = @JoinColumn(name= "drink_id"),
            inverseJoinColumns = @JoinColumn(name= "type_id")
    )
    private ArrayList<DrinkType> drinkTypes;
}
