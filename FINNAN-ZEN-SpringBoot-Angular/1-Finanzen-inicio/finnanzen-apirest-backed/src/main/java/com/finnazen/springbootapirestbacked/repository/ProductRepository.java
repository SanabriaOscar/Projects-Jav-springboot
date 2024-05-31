package com.finnazen.springbootapirestbacked.repository;

import com.finnazen.springbootapirestbacked.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository<Product, Long> {
    Product findByBarcode(String barcode);
}
