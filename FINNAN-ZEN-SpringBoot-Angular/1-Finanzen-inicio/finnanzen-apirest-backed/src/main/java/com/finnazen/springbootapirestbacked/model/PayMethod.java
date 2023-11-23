package com.finnazen.springbootapirestbacked.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Builder
@Setter
@Getter
@Entity
@AllArgsConstructor
@Table(name = "payMethods")
@NoArgsConstructor
public class PayMethod {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idPayMethod;
    @Column(nullable = false)
    private  String name;
   @JsonIgnore
    @OneToMany(mappedBy = "payMethod", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private List<Sale> sales;
}
