package com.example.bootemo.service.imp;

import com.example.bootemo.model.Blog;
import com.example.bootemo.model.Category;
import com.example.bootemo.repository.BlogRepository;
import com.example.bootemo.service.BlogService;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class BlogServiceImpl implements BlogService {
    @Autowired
    private BlogRepository blogRepository;

    @Override
    public List<Blog> findAll() {
        return (List<Blog>) blogRepository.findAll();
    }

    @Override
    public Blog findById(Long id) {
        return blogRepository.findById(id).get();
    }

    @Override
    public void save(Blog blog) {
        blogRepository.save(blog);
    }

    @Override
    public void delete(Long id) {
        blogRepository.deleteById(id);
    }

    @Override
    public List<Blog> findAllByCategory(Category category) {
        return blogRepository.findAllByCategory(category);
    }
    @Override
    public List<Blog> findAllByTitle(String name) {
        return blogRepository.findAllByTitleContaining(name);
    }
}
