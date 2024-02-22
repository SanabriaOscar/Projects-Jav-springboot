package com.example.MIcroservicio.service;

import com.example.MIcroservicio.exceptions.ResourceNotFoundException;
import com.example.MIcroservicio.model.Product;
import com.example.MIcroservicio.repository.ProductRepository;
import com.example.MIcroservicio.service.impl.ProductoServiceImpl;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.*;
import org.mockito.junit.MockitoJUnitRunner;


import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.junit.Assert.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyLong;
//@DataJpaTest
//@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
@RunWith(MockitoJUnitRunner.class)
public class ProductoServiceTest {

    @InjectMocks
    private ProductoServiceImpl productService;

    @Mock
    private ProductRepository productRepository;

 @Before
    public void init() {
        MockitoAnnotations.initMocks(this);
    }
   /* @BeforeEach
    public  void setup(){
        MockitoAnnotations.openMocks( this);
    }*/

    @Test
    public void testListAllProducts() {
        List<Product> productList = new ArrayList<>();
        productList.add(Product.builder().idProduct(1L).name("Product1").price(100.0).build());
        productList.add(Product.builder().idProduct(2L).name("Product2").price(200.0).build());

        Mockito.when(productRepository.findAll()).thenReturn(productList);

        List<Product> result = productService.listAllProducts();

        assertEquals(2, result.size());
    }

    @Test
    public void testSaveProduct() {
        Product product = Product.builder()
                .idProduct(1L)
                .name("Product1")
                .price(100.0)
                .build();
        Mockito.when(productRepository.save(ArgumentMatchers.any(Product.class))).thenReturn(product);

        Product savedProduct = productService.saveProduct(product);

        assertEquals(product, savedProduct);
    }


    @Test
    public void testFindByIdProduct() {
        Product product = Product.builder().idProduct(1L).name("Product1").price(100.0).build();

        Mockito.when(productRepository.findById(anyLong())).thenReturn(Optional.of(product));


        Product result = productService.findByIdProduct(1L);

        assertEquals(product, result);
    }

    @Test
    public void testUpdateProductById() {
        Product existingProduct = Product.builder().idProduct(1L).name("Product1").price(100.0).build();
        Product updatedProduct = Product.builder().idProduct(1L).name("UpdatedProduct1").price(150.0).build();
        Mockito.when(productRepository.findById(anyLong())).thenReturn(Optional.of(existingProduct));
        Mockito.when(productRepository.save(ArgumentMatchers.any(Product.class))).thenReturn(updatedProduct);
        Product result = productService.updateProductById(updatedProduct, 1L);
        assertEquals(updatedProduct, result);
    }

    @Test
    public void testDeleteProductById() {
        Product product = Product.builder()
                .idProduct(1L)
                .name("Product1")
                .price(100.0)
                .build();
        Mockito.when(productRepository.findById(product.getIdProduct())).thenReturn(Optional.of(product));
        Product deletedProduct = productService.deleteProductById(product.getIdProduct());
        Mockito.verify(productRepository).delete(product);

        assertEquals(product, deletedProduct);
    }



}
