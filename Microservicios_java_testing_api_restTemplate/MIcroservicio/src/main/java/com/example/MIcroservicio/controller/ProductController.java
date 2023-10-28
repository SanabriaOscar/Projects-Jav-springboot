package com.example.MIcroservicio.controller;



import com.example.MIcroservicio.exceptions.ErrorServerAdmin;
import com.example.MIcroservicio.exceptions.ResourceNotFoundException;
import com.example.MIcroservicio.model.Product;
import com.example.MIcroservicio.service.IProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api")
public class ProductController {
    @Autowired
    private IProductService productService;

    @GetMapping("/products")
    public ResponseEntity<Object> listAllProductsC() {
        try {
            List<Product> products = productService.listAllProducts();
            if (products.isEmpty()) {
                String successMessage = "No se encontraron productos.";
                return ResponseEntity.status(HttpStatus.OK).body(successMessage);
            } else {
                return ResponseEntity.status(HttpStatus.OK).body(products);
            }
        } catch (ErrorServerAdmin e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(e.getMessage());
        }
    }

    @PostMapping("/products")
    @ResponseStatus(HttpStatus.CREATED)
    public ResponseEntity<Object> saveProductC(@RequestBody Product product) {
        try {
            productService.saveProduct(product);
            String successMessage = "Producto creado con éxito.";
            Map<String, Object> response = new HashMap<>();
            response.put("message", successMessage);
            response.put("product", product);
            return ResponseEntity.status(HttpStatus.CREATED).body(response);
        } catch (ErrorServerAdmin e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(e.getMessage());
        }
    }

    @GetMapping("/products/{id}")
    public ResponseEntity<Object> findByIdProductC(@PathVariable Long id) {
        try {
            Product product = productService.findByIdProduct(id);
            if (product != null) {
                return ResponseEntity.ok(product);
            } else {
                String errorMessage = "No se encontró el producto con el id: " + id;
                return ResponseEntity.status(HttpStatus.NOT_FOUND).body(errorMessage);
            }
        } catch (ResourceNotFoundException e) {
            String errorMessage = e.getMessage();
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(errorMessage);
        }  catch (ErrorServerAdmin e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(e.getMessage());
        }
    }


    @PutMapping("/products/{id}")
    public ResponseEntity<Object> updateProductC(@RequestBody Product product, @PathVariable Long id) {
        try {
            Product productUpdated = productService.updateProductById(product, id);
            if (productUpdated != null) {
                String successMessage = "Producto actualizado con éxito.";
                Map<String, Object> response = new HashMap<>();
                response.put("message", successMessage);
                response.put("product", productUpdated);
                return ResponseEntity.status(HttpStatus.OK).body(response);
            }else {
                String errorMessage = "No se encontró el producto con el id: " + id;
                return ResponseEntity.status(HttpStatus.NOT_FOUND).body(errorMessage);
            }

        } catch (ResourceNotFoundException e) {
            String errorMessage = e.getMessage();
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(errorMessage);
        } catch (ErrorServerAdmin e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(e.getMessage());
        }
    }

    @DeleteMapping("/products/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public ResponseEntity<Object> deleteProductC(@PathVariable Long id) {
        try {
            Product deletedProduct = productService.findByIdProduct(id);
            if (deletedProduct != null) {
                productService.deleteProductById(id);
                return ResponseEntity.status(HttpStatus.OK).body("Producto eliminado con éxito.");
            } else {
                String errorMessage = "No se encontró el producto con el id: " + id;
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


    ////---------------------------

    //esto es MVC

    ////-----------------------

    /*@GetMapping("")
    public String getAllProducts(Model model) {
        List<Product> products = productService.listAllProducts();
        model.addAttribute("products", products);
        return "productList";
    }

    @GetMapping("/{id}")
    public String getProductById(@PathVariable(value = "id") Long id, Model model) {
        Product product = productService.findByIdProduct(id);
        model.addAttribute("product", product);
        return "productDetail";
    }

    @GetMapping("/create")
    public String createProductForm(Model model) {
        model.addAttribute("product", new Product());
        return "productForm";
    }

    @PostMapping("")
    public String createProduct(@ModelAttribute("product") Product product) {
        productService.saveProduct(product);
        return "redirect:/products";
    }

    @GetMapping("/{id}/edit")
    public String editProductForm(@PathVariable(value = "id") Long id, Model model) {
        Product product = productService.findByIdProduct(id);
        model.addAttribute("product", product);
        return "productForm";
    }

    @PostMapping("/{id}")
    public String updateProduct(@PathVariable(value = "id") Long id, @ModelAttribute("product") Product productDetails) {
        productService.UpdateProductById(productDetails, id);
        return "redirect:/products";
    }

    @GetMapping("/{id}/delete")
    public String deleteProduct(@PathVariable(value = "id") Long id) {
        productService.deleteProductById(id);
        return "redirect:/products";
    }*/



