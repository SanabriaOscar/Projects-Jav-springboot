package com.example.productorest.repositorio;

import com.example.productorest.modelo.Producto;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductoRepositorio extends JpaRepository <Producto, Integer> {

}
