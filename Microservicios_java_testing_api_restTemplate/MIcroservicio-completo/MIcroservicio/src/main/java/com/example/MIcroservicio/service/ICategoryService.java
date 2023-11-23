package com.example.MIcroservicio.service;

import com.example.MIcroservicio.model.Category;

import java.util.List;

public interface ICategoryService {

    public List<Category> listAllCategories();
    public Category saveCategory(Category category);
    public Category findByIdCategory(Long id);
    public Category UpdateCategoryById(Category category, Long id);
    public Category deleteCategory(Long id);



}
