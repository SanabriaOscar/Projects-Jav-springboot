package com.example.pruebaNTTDATA.model;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.Date;

@Entity
@Getter
@Setter
@Table(name ="tasks")
public class Task {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column(nullable = false, length = 40)
    private  String name;
    @Column(nullable = false, length = 40)
    private Date date;

    public Task() {
    }

    public Task(int id, String name) {
        this.id = id;
        this.name = name;
        this.date = date;
    }
}
