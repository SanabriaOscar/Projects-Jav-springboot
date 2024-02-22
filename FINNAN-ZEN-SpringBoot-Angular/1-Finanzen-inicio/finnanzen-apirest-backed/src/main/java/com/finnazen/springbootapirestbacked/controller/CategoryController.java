package com.finnazen.springbootapirestbacked.controller;

import com.finnazen.springbootapirestbacked.exceptions.ErrorServerAdmin;
import com.finnazen.springbootapirestbacked.exceptions.ResourceNotFoundException;
import com.finnazen.springbootapirestbacked.model.Category;
import com.finnazen.springbootapirestbacked.service.ICategoryService;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/categories")
public class CategoryController {
    private static final Logger logger = LogManager.getLogger(ClienteController.class);

    @Autowired
    private ICategoryService categoryService;

    @GetMapping
    public ResponseEntity<Object> listAllCategories() {
        try {
            List<Category> categories = categoryService.listAllCategorys();
            if (categories.isEmpty()) {
                String successMessage = "No se encontraron categorías.";
                return ResponseEntity.status(HttpStatus.OK).body(successMessage);
            } else {
                return ResponseEntity.status(HttpStatus.OK).body(categories);
            }
        } catch (ErrorServerAdmin e) {
            logger.error("Error al listar las categorías.", e);
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(e.getMessage());
        }
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public ResponseEntity<Object> saveCategory(@RequestBody Category category) {
        try {
            categoryService.saveCategory(category);
            String successMessage = "Categoría creada con éxito.";
            Map<String, Object> response = new HashMap<>();
            response.put("message", successMessage);
            response.put("category", category);
            return ResponseEntity.status(HttpStatus.CREATED).body(response);
        } catch (ErrorServerAdmin e) {
            logger.error("Error al guardar la categoría.", e);
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(e.getMessage());
        }
    }

    @GetMapping("/{id}")
    public ResponseEntity<Object> findByIdCategory(@PathVariable Long id) {
        try {
            Category category = categoryService.findByIdCategory(id);
            if (category != null) {
                return ResponseEntity.ok(category);
            } else {
                String errorMessage = "No se encontró la categoría con el id: " + id;
                return ResponseEntity.status(HttpStatus.NOT_FOUND).body(errorMessage);
            }
        } catch (ResourceNotFoundException e) {
            logger.error("Error al buscar la categoría por ID.", e);
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(e.getMessage());
        } catch (ErrorServerAdmin e) {
            logger.error("Error al buscar la categoría por ID.", e);
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(e.getMessage());
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity<Object> updateCategory(@RequestBody Category category, @PathVariable Long id) {
        try {
            Category categoryUpdated = categoryService.UpdateCategoryById(category, id);
            if (categoryUpdated != null) {
                String successMessage = "Categoría actualizada con éxito.";
                Map<String, Object> response = new HashMap<>();
                response.put("message", successMessage);
                response.put("category", categoryUpdated);
                return ResponseEntity.status(HttpStatus.OK).body(response);
            } else {
                String errorMessage = "No se encontró la categoría con el id: " + id;
                return ResponseEntity.status(HttpStatus.NOT_FOUND).body(errorMessage);
            }

        } catch (ResourceNotFoundException e) {
            logger.error("Error al actualizar la categoría.", e);
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(e.getMessage());
        } catch (ErrorServerAdmin e) {
            logger.error("Error al actualizar la categoría.", e);
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(e.getMessage());
        }
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public ResponseEntity<Object> deleteCategory(@PathVariable Long id) {
        try {
            Category deletedCategory = categoryService.findByIdCategory(id);
            if (deletedCategory != null) {
                categoryService.deleteCategoryById(id);
                return ResponseEntity.status(HttpStatus.OK).body("Categoría eliminada con éxito.");
            } else {
                String errorMessage = "No se encontró la categoría con el id: " + id;
                return ResponseEntity.status(HttpStatus.NOT_FOUND).body(errorMessage);
            }
        } catch (ResourceNotFoundException e) {
            logger.error("Error al eliminar la categoría.", e);
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(e.getMessage());
        } catch (ErrorServerAdmin e) {
            logger.error("Error al eliminar la categoría.", e);
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(e.getMessage());
        }
    }

}
