package com.example.MIcroservicio.consumoAPI;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import jakarta.persistence.*;
@Setter
@Getter
@AllArgsConstructor
@Entity
@NoArgsConstructor
@Table(name = "personajes")
public class StarWarsPerson {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String name;
    private String gender;


}
