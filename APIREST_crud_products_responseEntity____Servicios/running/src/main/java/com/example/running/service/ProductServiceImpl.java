package com.example.running.service;

import com.example.running.exceptions.ResourceNotFoundException;
import com.example.running.model.Product;
import com.example.running.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductServiceImpl implements IProductService {
    @Autowired
    private ProductRepository productRepository;

    @Override
    public Product saveProduct(Product product) {
        return productRepository.save(product);
    }

    @Override
    public List<Product> listAllProducts() {
        return productRepository.findAll();
    }

    public Product findBYIdProduct(Long id) {
        return productRepository.findById(id).
                //orElseThrow(()-> new ResourceNotFoundException("Product not exist with id :" + id));
         orElseThrow(()->new ResourceNotFoundException("Product not exist with id :" + id));
    }

    @Override
    public Product deleteByIdProduct(Long id) {
        productRepository.deleteById(id);
        return productRepository.findById(id).
                //orElseThrow(()-> new ResourceNotFoundException("Product not exist with id :" + id));
                        orElseThrow(()->new ResourceNotFoundException("Product not exist with id :" + id));
    }
}
