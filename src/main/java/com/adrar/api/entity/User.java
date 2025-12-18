package com.adrar.api.entity;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name="users")
@Data
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name="firstname", nullable=false,length=50)
    private String firstname;

    @Column(nullable=false, length=50)
    private String lastname;

    @Column(nullable=false, unique=true, length=50)
    private String email;

    @Column(nullable=false, length=100)
    private String password;

}
