package com.finnazen.springbootapirestbacked.service.impl;

import com.finnazen.springbootapirestbacked.exceptions.ResourceNotFoundException;
import com.finnazen.springbootapirestbacked.model.Product;
import com.finnazen.springbootapirestbacked.repository.ProductRepository;
import com.finnazen.springbootapirestbacked.service.IProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProductServiceImpl implements IProductService {
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
    public Product UpdateProductById(Product product, Long id) {
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
        return null;
    }

    @Override
    public Product findByBarcode(String barcode) {
        return productRepository.findByBarcode(barcode);
    }

}
