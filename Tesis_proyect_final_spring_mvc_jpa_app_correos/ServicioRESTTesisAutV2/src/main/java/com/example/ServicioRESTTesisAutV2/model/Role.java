package com.example.ServicioRESTTesisAutV2.model;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Builder
@Setter
@Getter
@Table(name = "roles")
public class Role {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int Id;
    @Column(name="name", nullable = false, length = 20)
    private String name;

    public Role(String name) {
        super();
        this.name = name;
    }

    public Role(int id, String name) {
        super();
        Id = id;
        this.name = name;
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

    public String getName() {
        return name;
    }

    public void setNombre(String name) {
        this.name = name;
    }

}
