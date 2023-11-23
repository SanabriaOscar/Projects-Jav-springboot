package com.finnazen.springbootapirestbacked.service;

import com.finnazen.springbootapirestbacked.model.Sale;;

import java.util.List;

public interface ISaleService {
    public List<Sale> listAllSales();
    public Sale saveSale(Sale sale);
    public Sale findByIdSale(Long id);
    public Sale UpdateSaleById(Sale sale, Long id);
    public Sale deleteSaleById(Long id);
}
