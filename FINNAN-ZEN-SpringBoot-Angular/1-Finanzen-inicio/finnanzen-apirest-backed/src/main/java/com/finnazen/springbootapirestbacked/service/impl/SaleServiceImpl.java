package com.finnazen.springbootapirestbacked.service.impl;

import com.finnazen.springbootapirestbacked.exceptions.ResourceNotFoundException;
import com.finnazen.springbootapirestbacked.model.Sale;
import com.finnazen.springbootapirestbacked.repository.SaleRepository;
import com.finnazen.springbootapirestbacked.service.ISaleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class SaleServiceImpl implements ISaleService{

    @Autowired
    private SaleRepository saleRepository;

    @Override
    public List<Sale> listAllSales() {
        return saleRepository.findAll();
    }

    @Override
    public Sale saveSale(Sale sale) {
        saleRepository.save(sale);
        return sale;
    }

    @Override
    public Sale findByIdSale(Long id) {
        Optional<Sale> sale = saleRepository.findById(id);
        if (!sale.isPresent()) {
            throw new ResourceNotFoundException("No se encontró venta con el id: " + id);
        }
        return sale.get();
    }

    @Override
    public Sale UpdateSaleById(Sale sale, Long id) {
        Optional<Sale> saleUpdate = saleRepository.findById(id);
        if (!saleUpdate.isPresent()) {
            throw new ResourceNotFoundException("No se encontró venta con el id: " + id);

        }
        sale.setIdSale(id);
        saleRepository.save(sale);
        return sale;
    }

    @Override
    public Sale deleteSaleById(Long id) {
        Optional<Sale> sale = saleRepository.findById(id);
        if (!sale.isPresent()) {
            throw new ResourceNotFoundException("No se encontró venta con el id: " + id);
        }
        saleRepository.delete(sale.get());
        return null;
    }
}
