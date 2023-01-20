package com.example.productorest.servicio;

import com.example.productorest.modelo.Producto;
import com.example.productorest.repositorio.ProductoRepositorio;
import com.fasterxml.jackson.databind.deser.impl.CreatorCandidate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductoServicio {
    @Autowired

    private ProductoRepositorio productoRepositorio;

    public List<Producto> listarProductos(){
        return  productoRepositorio.findAll();

    }
    public  void guardarProducto(Producto producto){
        productoRepositorio.save(producto);
    }

    public  Producto obtenerProductobyId(Integer id){
        return  productoRepositorio.findById(id).get();
    }
    public  void  eliminarProducto(Integer id){
        productoRepositorio.deleteById(id);
    }
}
