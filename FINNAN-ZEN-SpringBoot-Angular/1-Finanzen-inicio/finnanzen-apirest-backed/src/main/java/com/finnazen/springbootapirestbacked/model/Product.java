package com.finnazen.springbootapirestbacked.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@AllArgsConstructor
@Getter
@Setter
@Entity
@NoArgsConstructor
@Table(name = "products")
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idProduct;
    @Column(nullable = false)
    private  String name;
    @Column(nullable = true)
    private  double weight;
    @Column(nullable = true)
    private String barcode;
    @Column(nullable = true)
    private  double iva;
    @Column(nullable = false)
    private  double stock;
    @Column(nullable = false)
    private  double priceBuy;
    @Column(nullable = false)
    private  double pricesale;
    @ManyToOne
    @JoinColumn(name="idCategory")
    private Category category;
    @JsonIgnore
    @OneToMany(mappedBy = "product", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private List<Sale> sales;

}
