package com.example.Api_Spring_boot_globant.model;

import javax.persistence.*;

@Entity
@Table(name = "roles")
public class Role {

    @javax.persistence.Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int Id;
    @Column(name="nombre", nullable = false, length = 20)
    private String nombre;

    public Role(String nombre) {
        this.nombre = nombre;
    }

    public Role(int id, String nombre) {
        Id = id;
        this.nombre = nombre;
    }

    public Role() {
    }

    public Role(int i) {
    }

    public int getId() {
        return Id;
    }

    public void setId(int id) {
        Id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
}
