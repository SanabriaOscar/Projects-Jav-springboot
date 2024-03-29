package com.example.springbootapirestbacked.model;

import jakarta.persistence.*;

import java.io.Serializable;

@Entity
@Table(name = "regiones")
public class Region implements Serializable {
    public static final long serialversionUID=1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private  Long id;
    @Column
    private String nombre;

    public Region() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
}
