package com.finnazen.springbootapirestbacked.service;

import com.finnazen.springbootapirestbacked.model.Category;

import java.util.List;

public interface ICategoryService {
    public List<Category> listAllCategorys();
    public Category saveCategory(Category category);
    public Category findByIdCategory(Long id);
    public Category UpdateCategoryById(Category category, Long id);
    public  void deleteCategoryById(Long id);
}
