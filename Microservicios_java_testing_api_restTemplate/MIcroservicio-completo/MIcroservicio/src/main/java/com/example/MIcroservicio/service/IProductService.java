package com.example.MIcroservicio.service;

import com.example.MIcroservicio.model.Product;

import java.util.List;

public interface IProductService {
    public List<Product> listAllProducts();
    public Product saveProduct(Product product);
    public Product findByIdProduct(Long id);
    public Product updateProductById(Product product, Long id);
    public Product deleteProductById(Long id);

}
