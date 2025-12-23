package com.adrar.api.entity;

import jakarta.persistence.*;
import lombok.Data;
import org.hibernate.validator.constraints.Length;

@Entity
@Table(name = "drink_type")
@Data
public class DrinkType {

    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Integer id;

    @Column(nullable = false, unique = true)
    @Length(min = 2, max = 50)
    private String name;

    @Override
    public String toString()
    {
        return this.name;
    }
}
