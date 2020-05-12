package com.example.bootemo.model;


import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "category")
public class Category {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public List<Blog> getBlogs() {
        return blogs;
    }

    public void setBlogs(List<Blog> blogs) {
        this.blogs = blogs;
    }

    public Category() {
    }

    public Category(String category, List<Blog> blogs) {
        this.category = category;
        this.blogs = blogs;
    }

    private String category;

    @JsonIgnoreProperties(value = "category", allowSetters = true)
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "category",  orphanRemoval = true)
    private List<Blog> blogs;
}
