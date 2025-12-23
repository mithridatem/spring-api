package com.adrar.api.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.DecimalMin;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.Positive;
import lombok.Data;

@Entity
@Table(name="drink_price")
@Data
public class DrinkPrice {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(nullable = false)
    @Positive
    @DecimalMin(value= "0.5")
    private Double price;

    @ManyToOne(cascade = CascadeType.REMOVE)
    @JoinColumn(name = "drink_id")
    private Drink drink;

    @ManyToOne(cascade = CascadeType.REMOVE)
    @JoinColumn(name="drink_size_id")
    private DrinkSize drinkSize;

}
