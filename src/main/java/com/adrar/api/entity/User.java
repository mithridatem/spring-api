package com.adrar.api.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import lombok.*;
import org.hibernate.validator.constraints.Length;

@Entity
@Table(name="users")
@Data
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name="firstname", nullable=false,length=50)
    @NotBlank
    @Length(min=2, max=50)
    private String firstname;

    @Column(nullable=false, length=50)
    @NotBlank
    @Length(min=2, max=50)
    private String lastname;

    @Column(nullable=false, unique=true, length=50)
    @NotBlank
    @Length(min=2, max=50)
    @Email
    private String email;

    @Column(nullable=false, length=100)
    private String password;

    @Column(nullable=true, length=100)
    @NotBlank
    @Length(min=2, max=50)
    private String pseudo;
}
