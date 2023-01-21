package com.example.TestbbogotaREST.model;

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

   @ManyToOne(optional = true, cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private DocumentType documentType;

    public User(int id, String firstName, String secondName, String firstLastName, String secondLastName, int phoneNumber, int identification, String address,  DocumentType documentType) {

    }

    public User() {
        
    }

    public User(int id, String oscar, String jesus, String sanabria, String tavera, int phoneNumber, int identification, String address, String kennedy, DocumentType u) {
    }
}
