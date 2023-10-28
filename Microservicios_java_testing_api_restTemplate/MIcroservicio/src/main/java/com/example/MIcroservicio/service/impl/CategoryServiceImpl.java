package com.example.MIcroservicio.service.impl;

import com.example.MIcroservicio.exceptions.ResourceNotFoundException;
import com.example.MIcroservicio.model.Category;
import com.example.MIcroservicio.repository.CategoryRepository;
import com.example.MIcroservicio.service.ICategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CategoryServiceImpl implements ICategoryService {


    @Autowired
    private CategoryRepository categoryRepository;

    @Override
    public List<Category> listAllCategories() {
        return categoryRepository.findAll();
    }

    @Override
    public Category saveCategory(Category category) {
        categoryRepository.save(category);
        return category;
    }

    @Override
    public Category findByIdCategory(Long id) {
        Optional<Category> category = categoryRepository.findById(id);
        if (!category.isPresent()) {
            throw new ResourceNotFoundException("No se encontró la categoría con el id: " + id);
        }
        return category.get();
    }

    @Override
    public Category UpdateCategoryById(Category category, Long id) {
        Optional<Category> cate = categoryRepository.findById(id);
        if (!cate.isPresent()) {
            throw new ResourceNotFoundException("No se encontró la categoría con el id: " + id);
        }
        category.setIdCategory(id);
        return categoryRepository.save(category);
    }

    @Override
    public Category deleteCategory(Long id) {
        Optional<Category> category = categoryRepository.findById(id);
        if (!category.isPresent()) {
            throw new ResourceNotFoundException("No se encontró la categoría con el id: " + id);
        }
        categoryRepository.delete(category.get());
        return category.get();
    }

}
