package com.adrar.api.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.Size;
import lombok.Data;

@Entity
@Table(name="drink_size")
@Data
public class DrinkSize {

    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Integer id;

    @Column(nullable=false)
    @Min(2)
    @Max(100)
    private Integer volume;
}
