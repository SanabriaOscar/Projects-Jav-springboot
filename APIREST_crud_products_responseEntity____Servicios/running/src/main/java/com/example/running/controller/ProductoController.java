package com.example.running.controller;


import com.example.running.model.Product;
import com.example.running.service.IProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "http://localhost:3000")
@RestController
@RequestMapping("/api/v1/")
public class ProductoController {

    @Autowired
    IProductService iProductService;
    @GetMapping("/products")
    public List<Product> getAlProducts() {
        return iProductService.listAllProducts();
    }

    @PostMapping("/products")
    public Product createProduct(@RequestBody Product product) {
        return iProductService.saveProduct(product);
    }

    @GetMapping("/products/{id}")
    public ResponseEntity< Product > getproductById(@PathVariable Long id) {
  Product product = iProductService.findBYIdProduct(id);
        return ResponseEntity.ok(product);
    }

    @PutMapping("/employees/{id}")
    public ResponseEntity <Product> updateProduct(@PathVariable Long id, @RequestBody Product product) {
        Product productSet = iProductService.findBYIdProduct(id);

        productSet.setName(product.getName());
        productSet.setDescription(product.getDescription());

        Product updatedEProduct = iProductService.saveProduct(productSet);
        return ResponseEntity.ok(updatedEProduct);
    }

    @DeleteMapping("/products/{id}")
    public ResponseEntity<Product> deleteProduct(@PathVariable Long id){
       /* Product productSearch= iProductService.findBYIdProduct(id);
        if (null == productSearch) {
            return new ResponseEntity<Product>(HttpStatus.NOT_FOUND);
        }*/
        iProductService.deleteByIdProduct(id);
       // return new ResponseEntity<Product>(HttpStatus.OK);
        return null;
    }
}
