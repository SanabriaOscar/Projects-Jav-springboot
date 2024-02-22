package com.finnazen.springbootapirestbacked.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;
import java.util.List;

@AllArgsConstructor
@Getter
@Setter
@Entity
@NoArgsConstructor
@Table(name = "sales")
public class Sale {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idSale;
    private String description;
    private double total;
    private String costumerName;
    private Date date;
    private int state;
    @JsonIgnore
    @OneToMany(mappedBy = "sale", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private List<Deposit> deposits;

    @ManyToOne
    @JoinColumn(name="idproduct")
    private Product product;

    @ManyToOne
    @JoinColumn(name="idPayMethod")
    private PayMethod payMethod;

    @ManyToOne
    @JoinColumn(name="idUser")
    private User user;

}