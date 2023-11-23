package com.finnazen.springbootapirestbacked.model;

import jakarta.persistence.*;
import lombok.*;


@Builder
@Setter
@Getter
@Entity
@AllArgsConstructor
@Table(name = "deposits")
@NoArgsConstructor
public class PaymentDetails {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "payment_id")
    private Long paymentId;

    @Column(name = "payment_type")
    private String paymentType;

    @Column(name = "amount")
    private Double amount;

    @Column(name = "transaction_id")
    private String transactionId;
      /*@OneToMany(mappedBy = "idSale", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private List<Sale> sales;*/
}
