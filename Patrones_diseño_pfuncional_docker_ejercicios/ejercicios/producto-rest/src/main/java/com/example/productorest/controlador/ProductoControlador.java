package com.example.productorest.controlador;

import com.example.productorest.modelo.Producto;
import com.example.productorest.servicio.ProductoServicio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class ProductoControlador {
    @Autowired
    private ProductoServicio productoServicio;
    @GetMapping("/productos")
    public List<Producto> listarProductos(){
       return productoServicio.listarProductos();
    }
    @GetMapping("/productos/{id}")
public ResponseEntity<Producto> obtenerProducto(@PathVariable Integer id){
      //return   productoServicio.obtenerProductobyId(id).get();
     try {
      Producto producto= productoServicio.obtenerProductobyId(id);
      return new ResponseEntity<Producto>(producto,HttpStatus.OK);
     }catch (Exception exception){
         return new ResponseEntity<Producto>(HttpStatus.NOT_FOUND);
     }
    }

    @PostMapping("/productos")
    public void  guardarProducto(@RequestBody Producto producto){
        productoServicio.guardarProducto(producto);
    }

    @PutMapping("/productos/{id}")
    public  ResponseEntity<?>actualizarProducto(@RequestBody Producto producto, @PathVariable Integer id){
        try {
            Producto productoExite=productoServicio.obtenerProductobyId(id);
            productoExite.setNombre(producto.getNombre());
            productoExite.setPrecio(producto.getPrecio());
            productoServicio.guardarProducto(productoExite);
            return new ResponseEntity<Producto>(HttpStatus.OK);
        }catch (Exception exception){
            return new ResponseEntity<Producto>(HttpStatus.NOT_FOUND);
        }

    }
    @DeleteMapping("/productos{id}")

    public  void   eliminarProducto(@PathVariable Integer id){
        productoServicio.eliminarProducto(id);
    }

}
