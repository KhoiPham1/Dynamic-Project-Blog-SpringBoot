package com.example.bootemo.service.imp;

import com.example.bootemo.model.Category;
import com.example.bootemo.repository.CategoryRepository;
import com.example.bootemo.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class CategoryServiceImp implements CategoryService {
    @Autowired
    private CategoryRepository categoryRepository;

    @Override
    public List<Category> findAll() {
        return (List<Category>) categoryRepository.findAll();
    }

    @Override
    public Category findById(Long id) {
        return categoryRepository.findById(id).get();
    }

    @Override
    public void create(Category category) {
        categoryRepository.save(category);
    }
}
