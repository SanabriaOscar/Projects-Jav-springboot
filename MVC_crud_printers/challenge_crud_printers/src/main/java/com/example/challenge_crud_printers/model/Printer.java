package com.example.challenge_crud_printers.model;

import javax.persistence.*;

@Entity
@Table(name = "printers")
public class Printer {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private  int id;
    private  String nombrePrinter;

    public Printer(int id, String nombrePrinter) {
        this.id = id;
        this.nombrePrinter = nombrePrinter;
    }

    public Printer() {

    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNombrePrinter() {
        return nombrePrinter;
    }

    public void setNombrePrinter(String nombrePrinter) {
        this.nombrePrinter = nombrePrinter;
    }
}
