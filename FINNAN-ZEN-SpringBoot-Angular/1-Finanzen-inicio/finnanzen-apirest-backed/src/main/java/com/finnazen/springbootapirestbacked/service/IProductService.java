package com.finnazen.springbootapirestbacked.service;

import com.finnazen.springbootapirestbacked.model.Product;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public interface IProductService {
    public List<Product> listAllProducts();
    public Product saveProduct(Product product);
    public Product findByIdProduct(Long id);
    public Product UpdateProductById(Product product, Long id);
    public Product deleteProductById(Long id);
    public Product findByBarcode(String barcode);
}
