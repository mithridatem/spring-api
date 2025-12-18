package com.adrar.api.entity;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Table(name="drink_size")
@Data
public class DrinkSize {

    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Integer id;

    @Column(nullable=false, length=50)
    private Integer volume;
}
