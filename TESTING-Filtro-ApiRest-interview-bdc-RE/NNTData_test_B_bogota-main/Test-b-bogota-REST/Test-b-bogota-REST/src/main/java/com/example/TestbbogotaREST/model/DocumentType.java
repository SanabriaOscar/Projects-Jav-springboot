package com.example.TestbbogotaREST.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Table(name ="documentTypes")
@Setter
@Getter
@AllArgsConstructor

public class DocumentType {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column(nullable = false, length = 40)
    private  String name;

    public DocumentType() {

    }
}
