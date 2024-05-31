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
public Long getIdPayMethod() {
	return idPayMethod;
}
public void setIdPayMethod(Long idPayMethod) {
	this.idPayMethod = idPayMethod;
}
public String getName() {
	return name;
}
public void setName(String name) {
	this.name = name;
}
public List<Sale> getSales() {
	return sales;
}
public void setSales(List<Sale> sales) {
	this.sales = sales;
}
   
}
