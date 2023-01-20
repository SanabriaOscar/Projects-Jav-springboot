package com.example.running.service;


import com.example.running.model.Product;

import java.util.List;

public interface IProductService {

    public Product saveProduct(Product product);
    public List<Product>listAllProducts();
    public Product findBYIdProduct(Long id);
    public Product deleteByIdProduct(Long id);

}
