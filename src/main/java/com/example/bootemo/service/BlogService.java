package com.example.bootemo.service;

import com.example.bootemo.model.Blog;
import com.example.bootemo.model.Category;

import java.util.List;

public interface BlogService {
    List<Blog> findAll();

    Blog findById(Long id);

    void save(Blog blog);

    void delete(Long id);

    List<Blog> findAllByCategory (Category category);
}
