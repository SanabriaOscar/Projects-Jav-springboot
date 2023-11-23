package com.finnazen.springbootapirestbacked.controller;

import com.finnazen.springbootapirestbacked.exceptions.ErrorServerAdmin;
import com.finnazen.springbootapirestbacked.exceptions.ResourceNotFoundException;
import com.finnazen.springbootapirestbacked.model.PayMethod;
import com.finnazen.springbootapirestbacked.service.IPayMethodService;
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
@RequestMapping("/api/paymethods")
public class PayMethodController {

    private static final Logger logger = LoggerFactory.getLogger(PayMethodController.class);

    @Autowired
    private IPayMethodService payMethodService;

    @GetMapping
    public ResponseEntity<Object> listAllPayMethods() {
        try {
            List<PayMethod> payMethods = payMethodService.listAllPayMethods();
            if (payMethods.isEmpty()) {
                String successMessage = "No se encontraron métodos de pago.";
                return ResponseEntity.status(HttpStatus.OK).body(successMessage);
            } else {
                return ResponseEntity.status(HttpStatus.OK).body(payMethods);
            }
        } catch (ErrorServerAdmin e) {
            logger.error("Error al listar los métodos de pago.", e);
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(e.getMessage());
        }
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public ResponseEntity<Object> savePayMethod(@RequestBody PayMethod payMethod) {
        try {
            payMethodService.savePayMethod(payMethod);
            String successMessage = "Método de pago creado con éxito.";
            Map<String, Object> response = new HashMap<>();
            response.put("message", successMessage);
            response.put("payMethod", payMethod);
            return ResponseEntity.status(HttpStatus.CREATED).body(response);
        } catch (ErrorServerAdmin e) {
            logger.error("Error al guardar el método de pago.", e);
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(e.getMessage());
        }
    }

    @GetMapping("/{id}")
    public ResponseEntity<Object> findByIdPayMethod(@PathVariable Long id) {
        try {
            PayMethod payMethod = payMethodService.findByIdPayMethod(id);
            if (payMethod != null) {
                return ResponseEntity.ok(payMethod);
            } else {
                String errorMessage = "No se encontró el método de pago con el id: " + id;
                return ResponseEntity.status(HttpStatus.NOT_FOUND).body(errorMessage);
            }
        } catch (ResourceNotFoundException e) {
            logger.error("Error al buscar el método de pago por ID.", e);
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(e.getMessage());
        } catch (ErrorServerAdmin e) {
            logger.error("Error al buscar el método de pago por ID.", e);
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(e.getMessage());
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity<Object> updatePayMethod(@RequestBody PayMethod payMethod, @PathVariable Long id) {
        try {
            PayMethod payMethodUpdated = payMethodService.UpdatePayMethodById(payMethod, id);
            if (payMethodUpdated != null) {
                String successMessage = "Método de pago actualizado con éxito.";
                Map<String, Object> response = new HashMap<>();
                response.put("message", successMessage);
                response.put("payMethod", payMethodUpdated);
                return ResponseEntity.status(HttpStatus.OK).body(response);
            } else {
                String errorMessage = "No se encontró el método de pago con el id: " + id;
                return ResponseEntity.status(HttpStatus.NOT_FOUND).body(errorMessage);
            }

        } catch (ResourceNotFoundException e) {
            logger.error("Error al actualizar el método de pago.", e);
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(e.getMessage());
        } catch (ErrorServerAdmin e) {
            logger.error("Error al actualizar el método de pago.", e);
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(e.getMessage());
        }
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public ResponseEntity<Object> deletePayMethod(@PathVariable Long id) {
        try {
            PayMethod deletedPayMethod = payMethodService.findByIdPayMethod(id);
            if (deletedPayMethod != null) {
                payMethodService.deletePayMethodById(id);
                return ResponseEntity.status(HttpStatus.OK).body("Método de pago eliminado con éxito.");
            } else {
                String errorMessage = "No se encontró el método de pago con el id: " + id;
                return ResponseEntity.status(HttpStatus.NOT_FOUND).body(errorMessage);
            }
        } catch (ResourceNotFoundException e) {
            logger.error("Error al eliminar el método de pago.", e);
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(e.getMessage());
        } catch (ErrorServerAdmin e) {
            logger.error("Error al eliminar el método de pago.", e);
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(e.getMessage());
        }
    }
}
