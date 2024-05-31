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
	public Long getIdCategory() {
		return idCategory;
	}
	public void setIdCategory(Long idCategory) {
		this.idCategory = idCategory;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public List<Product> getProduct() {
		return product;
	}
	public void setProduct(List<Product> product) {
		this.product = product;
	}


}
