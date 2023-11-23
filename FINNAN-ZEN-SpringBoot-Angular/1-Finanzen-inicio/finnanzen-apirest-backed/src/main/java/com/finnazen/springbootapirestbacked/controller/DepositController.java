package com.finnazen.springbootapirestbacked.controller;

import com.finnazen.springbootapirestbacked.exceptions.ErrorServerAdmin;
import com.finnazen.springbootapirestbacked.exceptions.ResourceNotFoundException;
import com.finnazen.springbootapirestbacked.model.Deposit;
import com.finnazen.springbootapirestbacked.service.IDepositService;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/deposits")
public class DepositController {
    private static final Logger logger = LogManager.getLogger(ClienteController.class);


    @Autowired
    private IDepositService depositService;

    @GetMapping
    public ResponseEntity<Object> listAllDeposits() {
        try {
            List<Deposit> deposits = depositService.listAllDeposits();
            if (deposits.isEmpty()) {
                String successMessage = "No se encontraron depósitos.";
                return ResponseEntity.status(HttpStatus.OK).body(successMessage);
            } else {
                return ResponseEntity.status(HttpStatus.OK).body(deposits);
            }
        } catch (ErrorServerAdmin e) {
            logger.error("Error al listar los depósitos.", e);
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(e.getMessage());
        }
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public ResponseEntity<Object> saveDeposit(@RequestBody Deposit deposit) {
        try {
           // deposit.setCreateAt(new Date());
            depositService.saveDeposit(deposit);
            String successMessage = "Depósito creado con éxito.";
            Map<String, Object> response = new HashMap<>();
            response.put("message", successMessage);
            response.put("deposit", deposit);
            return ResponseEntity.status(HttpStatus.CREATED).body(response);
        } catch (ErrorServerAdmin e) {
            logger.error("Error al guardar el depósito.", e);
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(e.getMessage());
        }
    }

    @GetMapping("/{id}")
    public ResponseEntity<Object> findByIdDeposit(@PathVariable Long id) {
        try {
            Deposit deposit = depositService.findByIdDeposit(id);
            if (deposit != null) {
                return ResponseEntity.ok(deposit);
            } else {
                String errorMessage = "No se encontró el depósito con el id: " + id;
                return ResponseEntity.status(HttpStatus.NOT_FOUND).body(errorMessage);
            }
        } catch (ResourceNotFoundException e) {
            logger.error("Error al buscar el depósito por ID.", e);
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(e.getMessage());
        } catch (ErrorServerAdmin e) {
            logger.error("Error al buscar el depósito por ID.", e);
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(e.getMessage());
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity<Object> updateDeposit(@RequestBody Deposit deposit, @PathVariable Long id) {
        try {
            Deposit depositUpdated = depositService.UpdateDepositById(deposit, id);
            if (depositUpdated != null) {
                String successMessage = "Depósito actualizado con éxito.";
                Map<String, Object> response = new HashMap<>();
                response.put("message", successMessage);
                response.put("deposit", depositUpdated);
                return ResponseEntity.status(HttpStatus.OK).body(response);
            } else {
                String errorMessage = "No se encontró el depósito con el id: " + id;
                return ResponseEntity.status(HttpStatus.NOT_FOUND).body(errorMessage);
            }

        } catch (ResourceNotFoundException e) {
            logger.error("Error al actualizar el depósito.", e);
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(e.getMessage());
        } catch (ErrorServerAdmin e) {
            logger.error("Error al actualizar el depósito.", e);
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(e.getMessage());
        }
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public ResponseEntity<Object> deleteDeposit(@PathVariable Long id) {
        try {
            Deposit deletedDeposit = depositService.findByIdDeposit(id);
            if (deletedDeposit != null) {
                depositService.deleteDepositById(id);
                return ResponseEntity.status(HttpStatus.OK).body("Depósito eliminado con éxito.");
            } else {
                String errorMessage = "No se encontró el depósito con el id: " + id;
                return ResponseEntity.status(HttpStatus.NOT_FOUND).body(errorMessage);
            }
        } catch (ResourceNotFoundException e) {
            logger.error("Error al eliminar el depósito.", e);
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(e.getMessage());
        } catch (ErrorServerAdmin e) {
            logger.error("Error al eliminar el depósito.", e);
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(e.getMessage());
        }
    }
}
