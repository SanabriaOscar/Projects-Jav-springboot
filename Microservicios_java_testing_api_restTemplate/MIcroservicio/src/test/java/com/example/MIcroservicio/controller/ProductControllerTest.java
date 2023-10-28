package com.example.MIcroservicio.controller;

import com.example.MIcroservicio.model.Product;
import com.example.MIcroservicio.service.IProductService;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.util.ArrayList;
import java.util.List;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@RunWith(MockitoJUnitRunner.class)
public class ProductControllerTest {

    private MockMvc mockMvc;

    @InjectMocks
    private ProductController productController;

    @Mock
    private IProductService productService;

    @Before
    public void init() {
        mockMvc = MockMvcBuilders.standaloneSetup(productController).build();
    }

    @Test
    public void testListAllProductsEndpoint() throws Exception {
        List<Product> productList = new ArrayList<>();
        productList.add(Product.builder().idProduct(1L).name("Product1").price(100.0).build());
        productList.add(Product.builder().idProduct(2L).name("Product2").price(200.0).build());
        Mockito.when(productService.listAllProducts()).thenReturn(productList);

        mockMvc.perform(get("/api/products"))
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(jsonPath("$.size()").value(productList.size()));
    }

    @Test
    public void testSaveProductEndpoint() throws Exception {
        Product product = Product.builder()
                .idProduct(1L)
                .name("Product1")
                .price(100.0)
                .build();
        Mockito.when(productService.saveProduct(product)).thenReturn(product);

        mockMvc.perform(post("/api/products")
                        .content(asJsonString(product))
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isCreated());
    }

    @Test
    public void testFindByIdProductEndpoint() throws Exception {
        long productId = 1L;
        Product product = Product.builder().idProduct(productId).name("Product1").price(100.0).build();
        Mockito.when(productService.findByIdProduct(productId)).thenReturn(product);

        mockMvc.perform(get("/api/products/" + productId))
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(jsonPath("idProduct").value(productId));
    }

    @Test
    public void testUpdateProductEndpoint() throws Exception {
        long productId = 1L;
        Product product = Product.builder()
                .idProduct(productId)
                .name("UpdatedProduct1")
                .price(150.0)
                .build();
        Mockito.when(productService.updateProductById(product, productId)).thenReturn(product);

        mockMvc.perform(put("/api/products/" + productId)
                        .content(asJsonString(product))
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk());
    }

    @Test
    public void testDeleteProductEndpoint() throws Exception {
        long productId = 1L;
        Product product = Product.builder().idProduct(productId).name("Product1").price(100.0).build();
        Mockito.when(productService.findByIdProduct(productId)).thenReturn(product);

        mockMvc.perform(delete("/api/products/" + productId))
                .andExpect(status().isOk());
    }

    private static String asJsonString(final Object obj) {
        try {
            final ObjectMapper mapper = new ObjectMapper();
            return mapper.writeValueAsString(obj);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}

