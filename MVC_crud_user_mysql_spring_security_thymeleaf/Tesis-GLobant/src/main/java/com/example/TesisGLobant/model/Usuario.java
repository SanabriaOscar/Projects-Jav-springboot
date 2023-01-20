package com.example.TesisGLobant.model;

import javax.persistence.*;
import java.io.Serializable;

@Entity
public class Usuario implements Serializable  {
    //private  static  final long serialVersionUID =1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private  long id;
    @Column(nullable = false, length = 60)
    private  String nombre;
    @Column(nullable = false, length = 60)
    private  String apellido;
    @Column(nullable = false, length = 60)
    private  String email;
    @Column(nullable = false, length = 60)
    private  String password;

    public Usuario() {
    }

    public Usuario(long id, String nombre, String apellido, String email, String password) {
        this.id = id;
        this.nombre = nombre;
        this.apellido = apellido;
        this.email = email;
        this.password = password;
    }

    public Usuario(long id, String email, String password) {
        this.id = id;
        this.email = email;
        this.password = password;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
