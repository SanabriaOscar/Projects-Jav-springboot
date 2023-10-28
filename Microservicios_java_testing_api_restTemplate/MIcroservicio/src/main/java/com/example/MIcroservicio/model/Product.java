package com.example.MIcroservicio.model;



import jakarta.persistence.*;
import lombok.*;

@Setter
@Getter
@Builder
@Data
@AllArgsConstructor
@Entity


@NoArgsConstructor
@Table(name = "products")
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idProduct;
    @Column(name = "name", nullable = false)
    private String name;
    @Column(nullable = false)
    private double price;

    @ManyToOne
    @JoinColumn(name="idCategory")
    private Category category;

    public Product(Long idProduct, String name, Double price) {
        this.idProduct = idProduct;
        this.name = name;
        this.price = price;
    }

}
