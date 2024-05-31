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
	public Long getIdDeposit() {
		return idDeposit;
	}
	public void setIdDeposit(Long idDeposit) {
		this.idDeposit = idDeposit;
	}
	public double getMonto() {
		return monto;
	}
	public void setMonto(double monto) {
		this.monto = monto;
	}
	public Date getDate() {
		return date;
	}
	public void setDate(Date date) {
		this.date = date;
	}
	public Sale getSale() {
		return sale;
	}
	public void setSale(Sale sale) {
		this.sale = sale;
	}
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
    
}
