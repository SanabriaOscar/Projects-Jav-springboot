package com.example.MIcroservicio.service;

import com.example.MIcroservicio.model.Category;
import com.example.MIcroservicio.repository.CategoryRepository;
import com.example.MIcroservicio.service.impl.CategoryServiceImpl;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.ArgumentMatchers;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.junit.Assert.assertEquals;
import static org.mockito.ArgumentMatchers.anyLong;

@RunWith(MockitoJUnitRunner.class)
public class CategoryServiceTest {

    @InjectMocks
    private CategoryServiceImpl categoryService;

    @Mock
    private CategoryRepository categoryRepository;

    @Test
    public void testListAllCategories() {
        List<Category> categoryList = new ArrayList<>();
        categoryList.add(Category.builder().idCategory(1L).name("Category1").build());
        categoryList.add(Category.builder().idCategory(2L).name("Category2").build());
        Mockito.when(categoryRepository.findAll()).thenReturn(categoryList);
        List<Category> result = categoryService.listAllCategories();
        assertEquals(2, result.size());
    }

    @Test
    public void testSaveCategory() {
        Category category = Category.builder()
                .idCategory(1L)
                .name("Category1")
                .build();
        Mockito.when(categoryRepository.save(ArgumentMatchers.any(Category.class))).thenReturn(category);
        Category savedCategory = categoryService.saveCategory(category);
        assertEquals(category, savedCategory);
    }

    @Test
    public void testFindByIdCategory() {
        Category category = Category.builder().idCategory(1L).name("Category1").build();
        Mockito.when(categoryRepository.findById(anyLong())).thenReturn(Optional.of(category));
        Category result = categoryService.findByIdCategory(1L);
        assertEquals(category, result);
    }

    @Test
    public void testUpdateCategoryById() {
        Category existingCategory = Category.builder().idCategory(1L).name("Category1").build();
        Category updatedCategory = Category.builder().idCategory(1L).name("UpdatedCategory1").build();
        Mockito.when(categoryRepository.findById(anyLong())).thenReturn(Optional.of(existingCategory));
        Mockito.when(categoryRepository.save(ArgumentMatchers.any(Category.class))).thenReturn(updatedCategory);
        Category result = categoryService.UpdateCategoryById(updatedCategory, 1L);
        assertEquals(updatedCategory, result);
    }

    @Test
    public void testDeleteCategory() {
        Category category = Category.builder()
                .idCategory(1L)
                .name("Category1")
                .build();
        Mockito.when(categoryRepository.findById(category.getIdCategory())).thenReturn(Optional.of(category));
        Category deletedCategory = categoryService.deleteCategory(category.getIdCategory());
        Mockito.verify(categoryRepository).delete(category);
        assertEquals(category, deletedCategory);
    }
}
