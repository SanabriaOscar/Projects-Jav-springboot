package com.finnazen.springbootapirestbacked.service.impl;

import com.finnazen.springbootapirestbacked.exceptions.ResourceNotFoundException;
import com.finnazen.springbootapirestbacked.model.Category;
import com.finnazen.springbootapirestbacked.repository.CategoryRepository;
import com.finnazen.springbootapirestbacked.service.ICategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CategoryServiceImpl implements ICategoryService {

    @Autowired
    private CategoryRepository categoryRepository;
    @Override
    public List<Category>listAllCategorys(){
        return categoryRepository.findAll();
    }
    @Override
    public Category saveCategory(Category servicio){
        categoryRepository.save(servicio);
return servicio;
    }
    @Override
    public Category findByIdCategory(Long id){
        Optional<Category> category = categoryRepository.findById(id);
        if (!category.isPresent()) {
            throw new ResourceNotFoundException("No se encontró la categoría con el id: " + id);
        }
        return  category.get();
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
    public  void deleteCategoryById(Long id){
        Optional<Category> category = categoryRepository.findById(id);
        if (!category.isPresent()) {
            throw new ResourceNotFoundException("No se encontró la categoría con el id: " + id);
        }
       categoryRepository.delete(category.get());
    }
}
