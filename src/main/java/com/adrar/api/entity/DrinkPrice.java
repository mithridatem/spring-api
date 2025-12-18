package com.adrar.api.entity;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Table(name="drink_price")
@Data
public class DrinkPrice {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(nullable = false)
    private Double price;

    @ManyToOne
    @JoinColumn(name = "drink_id")
    private Drink drink;

    @ManyToOne
    @JoinColumn(name="drink_size_id")
    private DrinkSize drinkSize;

}
