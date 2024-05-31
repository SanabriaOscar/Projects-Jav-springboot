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
	public Long getIdProduct() {
		return idProduct;
	}
	public void setIdProduct(Long idProduct) {
		this.idProduct = idProduct;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public double getWeight() {
		return weight;
	}
	public void setWeight(double weight) {
		this.weight = weight;
	}
	public String getBarcode() {
		return barcode;
	}
	public void setBarcode(String barcode) {
		this.barcode = barcode;
	}
	public double getIva() {
		return iva;
	}
	public void setIva(double iva) {
		this.iva = iva;
	}
	public double getStock() {
		return stock;
	}
	public void setStock(double stock) {
		this.stock = stock;
	}
	public double getPriceBuy() {
		return priceBuy;
	}
	public void setPriceBuy(double priceBuy) {
		this.priceBuy = priceBuy;
	}
	public double getPricesale() {
		return pricesale;
	}
	public void setPricesale(double pricesale) {
		this.pricesale = pricesale;
	}
	public Category getCategory() {
		return category;
	}
	public void setCategory(Category category) {
		this.category = category;
	}
	public List<Sale> getSales() {
		return sales;
	}
	public void setSales(List<Sale> sales) {
		this.sales = sales;
	}
    

}
