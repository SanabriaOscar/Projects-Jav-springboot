package com.example.MIcroservicio.controller;


import com.example.MIcroservicio.model.Category;
import com.example.MIcroservicio.service.ICategoryService;
import com.example.MIcroservicio.service.impl.CategoryServiceImpl;
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
public class CategoryControllerTest {

    private MockMvc mockMvc;

    @InjectMocks
    private CategoryController categoryController;

    @Mock
    private CategoryServiceImpl categoryService;

    @Before
    public void init() {
        mockMvc = MockMvcBuilders.standaloneSetup(categoryController).build();
    }

    @Test
    public void testListAllCategoriesEndpoint() throws Exception {
        List<Category> categoryList = new ArrayList<>();
        categoryList.add(Category.builder().idCategory(1L).name("Category1").build());
        categoryList.add(Category.builder().idCategory(2L).name("Category2").build());
        Mockito.when(categoryService.listAllCategories()).thenReturn(categoryList);

        mockMvc.perform(get("/api/categorias"))
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(jsonPath("$.size()").value(categoryList.size()));
    }

    @Test
    public void testSaveCategoryEndpoint() throws Exception {
        Category category = Category.builder()
                .idCategory(1L)
                .name("Category1")
                .build();
        Mockito.when(categoryService.saveCategory(category)).thenReturn(category);

        mockMvc.perform(post("/api/categorias")
                        .content(asJsonString(category))
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isCreated());
              // .andExpect(jsonPath("name").value("Category1"));
    }

    @Test
    public void testFindByIdCategoryEndpoint() throws Exception {
        long categoryId = 1L;
        Category category = Category.builder().idCategory(categoryId).name("Category1").build();
        Mockito.when(categoryService.findByIdCategory(categoryId)).thenReturn(category);

        mockMvc.perform(get("/api/categorias/" + categoryId))
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(jsonPath("idCategory").value(categoryId));
    }

    @Test
    public void testUpdateCategoryEndpoint() throws Exception {
        long categoryId = 1L;
        Category category = Category.builder()
                .idCategory(categoryId)
                .name("UpdatedCategory1")
                .build();
        Mockito.when(categoryService.UpdateCategoryById(category, categoryId)).thenReturn(category);

        mockMvc.perform(put("/api/categorias/" + categoryId)
                        .content(asJsonString(category))
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk());
               // .andExpect(jsonPath("name").value("UpdatedCategory1"));
    }

    @Test
    public void testDeleteCategoryEndpoint() throws Exception {
        long categoryId = 1L;
        Category category = Category.builder().idCategory(categoryId).name("Category1").build();
        Mockito.when(categoryService.findByIdCategory(categoryId)).thenReturn(category);

        mockMvc.perform(delete("/api/categorias/" + categoryId))
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
