package com.example.BBVApruebaNNData.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
@Getter
@Setter
@AllArgsConstructor
@Entity
@Table(name ="users")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column( length = 40)
    private  String firstName;
    @Column( length = 40)
    private  String secondName;
    @Column( length = 40)
    private  String firstLastName;
    @Column( length = 40)
    private  String secondLastName;
    @Column( length = 60)
    private  int phoneNumber;
    @Column( length = 40)
    private  String identification;
    @Column( length = 40)
    private  String address;
    @Column( length = 40)
    private String city;

   @ManyToOne(optional = true, cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private DocumentType documentType;

    public User(int id, String firstName, String secondName, String firstLastName, String secondLastName, int phoneNumber, int identification, String address, String city, DocumentType documentType) {

    }

    public User() {
        
    }

}
