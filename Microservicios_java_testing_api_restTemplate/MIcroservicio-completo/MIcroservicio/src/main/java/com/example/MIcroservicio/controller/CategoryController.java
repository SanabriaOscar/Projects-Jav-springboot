package com.example.MIcroservicio.controller;


import com.example.MIcroservicio.exceptions.ErrorServerAdmin;
import com.example.MIcroservicio.exceptions.ResourceNotFoundException;
import com.example.MIcroservicio.model.Category;
import com.example.MIcroservicio.service.ICategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api")
public class CategoryController {

    @Autowired
    private ICategoryService categoryService;
        @GetMapping("/categorias")
        public ResponseEntity<Object> listAllCategoriesC() {
            try {
                List<Category> categories = categoryService.listAllCategories();
                if (categories.isEmpty()) {
                    String successMessage = "No se encontraron categorías.";
                    return ResponseEntity.status(HttpStatus.OK).body(successMessage);
                } else {
                    return ResponseEntity.status(HttpStatus.OK).body(categories);
                }
            }  catch (ErrorServerAdmin e) {
                return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(e.getMessage());
            }
        }

        @PostMapping("/categorias")
        @ResponseStatus(HttpStatus.CREATED)
        public ResponseEntity<Object> saveCategoryC(@RequestBody Category category) {
            try {
                categoryService.saveCategory(category);
                String successMessage = "Categoría creada con éxito.";
                Map<String, Object> response = new HashMap<>();
                response.put("message", successMessage);
                response.put("category", category);
                return ResponseEntity.status(HttpStatus.CREATED).body(response);
            }  catch (ErrorServerAdmin e) {
                return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(e.getMessage());
            }
        }

        @GetMapping("/categorias/{id}")
        public ResponseEntity<Object> findByIdCategoryC(@PathVariable long id) {
            try {
                Category category = categoryService.findByIdCategory(id);
                if (category != null) {
                    return ResponseEntity.ok(category);
                } else {
                    String errorMessage = "No se encontró la categoría con el id: " + id;
                    return ResponseEntity.status(HttpStatus.NOT_FOUND).body(errorMessage);
                }
            } catch (ResourceNotFoundException e) {
                String errorMessage = e.getMessage();
                return ResponseEntity.status(HttpStatus.NOT_FOUND).body(errorMessage);
            }  catch (ErrorServerAdmin e) {
                return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(e.getMessage());
            }
        }

        @PutMapping("/categorias/{id}")
        @ResponseStatus(HttpStatus.OK)
        public ResponseEntity<Object> updateCategoryC(@RequestBody Category category, @PathVariable Long id) {
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
                String errorMessage = e.getMessage();
                return ResponseEntity.status(HttpStatus.NOT_FOUND).body(errorMessage);
            }  catch (ErrorServerAdmin e) {
                return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(e.getMessage());
            }
        }

    @DeleteMapping("/categorias/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public ResponseEntity<Object> deleteCategoryC(@PathVariable Long id) {
        try {
            Category deletedCategory = categoryService.findByIdCategory(id);
            if (deletedCategory != null) {
                categoryService.deleteCategory(id);
                return ResponseEntity.status(HttpStatus.OK).body("Categoría eliminada con éxito.");
            } else {
                String errorMessage = "No se encontró la categoría con el id: " + id;
                return ResponseEntity.status(HttpStatus.NOT_FOUND).body(errorMessage);
            }
        } catch (ResourceNotFoundException e) {
            String errorMessage = e.getMessage();
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(errorMessage);
        } catch (ErrorServerAdmin e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(e.getMessage());
        }
    }


}


