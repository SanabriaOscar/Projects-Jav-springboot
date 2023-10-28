package com.example.MIcroservicio.model;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;

import lombok.*;

import java.util.List;

@Setter
@Getter
@AllArgsConstructor
@Builder
@Data
@Entity
@NoArgsConstructor
@Table(name = "categories")
public class Category {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idCategory;
    @Column(name = "name", nullable = false)
    private String name;
    @Column(nullable = false)
    private String description;

    @JsonIgnore
    @OneToMany(mappedBy="idProduct", cascade=CascadeType.ALL, fetch = FetchType.EAGER)
    private List<Product> product;
}
