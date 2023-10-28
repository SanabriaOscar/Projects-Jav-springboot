package com.example.MIcroservicio.service.impl;

import com.example.MIcroservicio.exceptions.ResourceNotFoundException;
import com.example.MIcroservicio.model.Product;
import com.example.MIcroservicio.repository.ProductRepository;
import com.example.MIcroservicio.service.IProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
@Service
public class ProductoServiceImpl implements IProductService {
    @Autowired
    private ProductRepository productRepository;
    @Override
    public List<Product> listAllProducts() {
        return productRepository.findAll();
    }

    @Override
    public Product saveProduct(Product product) {
        productRepository.save(product);
        return product;
    }

    @Override
    public Product findByIdProduct(Long id) {
        Optional<Product> product = productRepository.findById(id);
        if (!product.isPresent()) {
            throw new ResourceNotFoundException("No se encontró el producto con el id: " + id);
        }
        return product.get();
    }


    @Override
    public Product updateProductById(Product product, Long id) {
        Optional<Product> productUpdate = productRepository.findById(id);
        if (!productUpdate.isPresent()) {
            throw new ResourceNotFoundException("No se encontró el producto con el id: " + id);
        }
        product.setIdProduct(id);
        productRepository.save(product);
        return product;
    }

    @Override
    public Product deleteProductById(Long id) {
        Optional<Product> product = productRepository.findById(id);
        if (!product.isPresent()) {
            throw new ResourceNotFoundException("No se encontró el producto con el id: " + id);
        }
        productRepository.delete(product.get());
        return product.get();
    }

}
