package com.finnazen.springbootapirestbacked.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.CollectionId;
import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Type;

import java.util.Collection;
import java.util.List;

@Setter
@Getter
@Entity
@Table(name = "users", uniqueConstraints ={@UniqueConstraint(columnNames = {"email"})})
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idUser;
    @Column(nullable = false, length = 20)
    private String name;
    @Column(nullable = false, length = 20)
    private String lastname;
    @Column(nullable = false, length = 30, unique = true)
    private String identification;
    @Column(length = 40)
    private String email;
    @Column(length = 100)
    private String password;
    @JsonIgnore
    @OneToMany(mappedBy = "user")
    private List<PermisosUserRol> permisosUserRoles;
    @JsonIgnore
    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private List<Sale> sales;

}
