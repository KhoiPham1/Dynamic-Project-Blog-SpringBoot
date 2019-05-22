package com.example.bootemo.service;

import com.example.bootemo.model.Category;

import java.util.List;

public interface CategoryService {

    List<Category> findAll();

    Category findById (Long id);

    void create (Category category);

}
