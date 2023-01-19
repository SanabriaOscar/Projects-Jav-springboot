package com.example.running.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Getter;
import lombok.Setter;


@Setter
@Getter
@Entity
public class Product {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    private  Long id;
    private  String name;
    private  String description;

}
