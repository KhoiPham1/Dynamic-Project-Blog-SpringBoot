package com.example.bootemo.repository;

import com.example.bootemo.model.Blog;
import com.example.bootemo.model.Category;
import org.springframework.data.repository.PagingAndSortingRepository;

import java.util.List;

public interface BlogRepository extends PagingAndSortingRepository<Blog, Long> {
    List<Blog> findAllByCategory (Category category);
}
