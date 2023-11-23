package com.finnazen.springbootapirestbacked.model;

import jakarta.persistence.*;
import lombok.*;

import java.util.Date;
@Builder
@Setter
@Getter
@Entity
@AllArgsConstructor
@Table(name = "deposits")
@NoArgsConstructor
public class Deposit {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idDeposit;
    @Column(nullable = false)
    private  double monto;
    @Column(nullable = false)
    private Date date;

   @ManyToOne
    @JoinColumn(name="idSale")
    private Sale sale;
    @ManyToOne
    @JoinColumn(name="idUser")
    private User user;
}
