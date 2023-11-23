package com.finnazen.springbootapirestbacked.controller;

import com.finnazen.springbootapirestbacked.exceptions.ErrorServerAdmin;
import com.finnazen.springbootapirestbacked.exceptions.ResourceNotFoundException;
import com.finnazen.springbootapirestbacked.model.Sale;
import com.finnazen.springbootapirestbacked.service.ISaleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/api/sales")
public class SaleController {

    private static final Logger logger = LoggerFactory.getLogger(SaleController.class);

    @Autowired
    private ISaleService saleService;

    @GetMapping
    public ResponseEntity<Object> listAllSales() {
        try {
            List<Sale> sales = saleService.listAllSales();
            if (sales.isEmpty()) {
                String successMessage = "No se encontraron ventas.";
                return ResponseEntity.status(HttpStatus.OK).body(successMessage);
            } else {
                return ResponseEntity.status(HttpStatus.OK).body(sales);
            }
        } catch (ErrorServerAdmin e) {
            logger.error("Error al listar las ventas.", e);
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(e.getMessage());
        }
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public ResponseEntity<Object> saveSale(@RequestBody Sale sale) {
        try {
            saleService.saveSale(sale);
            String successMessage = "Venta creada con éxito.";
            Map<String, Object> response = new HashMap<>();
            response.put("message", successMessage);
            response.put("sale", sale);
            return ResponseEntity.status(HttpStatus.CREATED).body(response);
        } catch (ErrorServerAdmin e) {
            logger.error("Error al guardar la venta.", e);
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(e.getMessage());
        }
    }

    @GetMapping("/{id}")
    public ResponseEntity<Object> findByIdSale(@PathVariable Long id) {
        try {
            Sale sale = saleService.findByIdSale(id);
            if (sale != null) {
                return ResponseEntity.ok(sale);
            } else {
                String errorMessage = "No se encontró la venta con el id: " + id;
                return ResponseEntity.status(HttpStatus.NOT_FOUND).body(errorMessage);
            }
        } catch (ResourceNotFoundException e) {
            logger.error("Error al buscar la venta por ID.", e);
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(e.getMessage());
        } catch (ErrorServerAdmin e) {
            logger.error("Error al buscar la venta por ID.", e);
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(e.getMessage());
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity<Object> updateSale(@RequestBody Sale sale, @PathVariable Long id) {
        try {
            Sale saleUpdated = saleService.UpdateSaleById(sale, id);
            if (saleUpdated != null) {
                String successMessage = "Venta actualizada con éxito.";
                Map<String, Object> response = new HashMap<>();
                response.put("message", successMessage);
                response.put("sale", saleUpdated);
                return ResponseEntity.status(HttpStatus.OK).body(response);
            } else {
                String errorMessage = "No se encontró la venta con el id: " + id;
                return ResponseEntity.status(HttpStatus.NOT_FOUND).body(errorMessage);
            }

        } catch (ResourceNotFoundException e) {
            logger.error("Error al actualizar la venta.", e);
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(e.getMessage());
        } catch (ErrorServerAdmin e) {
            logger.error("Error al actualizar la venta.", e);
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(e.getMessage());
        }
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public ResponseEntity<Object> deleteSale(@PathVariable Long id) {
        try {
            Sale deletedSale = saleService.findByIdSale(id);
            if (deletedSale != null) {
                saleService.deleteSaleById(id);
                return ResponseEntity.status(HttpStatus.OK).body("Venta eliminada con éxito.");
            } else {
                String errorMessage = "No se encontró la venta con el id: " + id;
                return ResponseEntity.status(HttpStatus.NOT_FOUND).body(errorMessage);
            }
        } catch (ResourceNotFoundException e) {
            logger.error("Error al eliminar la venta.", e);
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(e.getMessage());
        } catch (ErrorServerAdmin e) {
            logger.error("Error al eliminar la venta.", e);
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(e.getMessage());
        }
    }
}
