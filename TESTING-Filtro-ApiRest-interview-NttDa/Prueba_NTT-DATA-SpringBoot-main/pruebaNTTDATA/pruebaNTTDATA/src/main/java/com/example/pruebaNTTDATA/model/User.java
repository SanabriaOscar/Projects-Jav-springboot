package com.example.pruebaNTTDATA.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.Date;

@Entity
@Getter
@Setter
@AllArgsConstructor
@Table(name ="users")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column(nullable = false, length = 40)
    private  String name;
    @Column(nullable = false, length = 40)
    private  String lastName;
    @Column(nullable = false, length = 40)
    private  int phoneNumber;
    @Column(nullable = false, length = 40)
    private  String address;
    @Column(nullable = false, length = 40)
    private String dateAge;
    @ManyToOne(optional = true, cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private Task task;

    public User() {

    }

    public User(int i, String other, String sanches, String calle45, int i1, Task fixed_a_cumputer) {
    }
}
