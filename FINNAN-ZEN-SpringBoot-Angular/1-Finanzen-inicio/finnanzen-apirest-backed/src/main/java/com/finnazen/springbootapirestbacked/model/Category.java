package com.finnazen.springbootapirestbacked.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

//import javax.persistence.*;
    @Getter
    @Setter
    @Entity
    @AllArgsConstructor
    @NoArgsConstructor
@Table(name = "categorys")

public class Category {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private  Long idCategory;
    @Column(name = "name", nullable = false)
    private String name;
    @Column(name = "description", nullable = false)
    private String description;
    @JsonIgnore
    @OneToMany(mappedBy="category", cascade=CascadeType.ALL, fetch = FetchType.EAGER)
    private List<Product> product;


}
