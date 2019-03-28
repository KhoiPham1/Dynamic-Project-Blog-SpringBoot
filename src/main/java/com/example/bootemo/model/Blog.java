package com.example.bootemo.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonManagedReference;

import javax.persistence.*;

@Entity
@Table(name = "blog")
public class Blog {
    @Id
    @GeneratedValue
    private Long id;

    private String title;
    @Column(columnDefinition = "LONGTEXT")
    private String content;
    private String nameImg;
    private Boolean boxCheck;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "categoryId")
    @JsonIgnoreProperties(value = "blogs", allowSetters = true)
    private Category category;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getNameImg() {
        return nameImg;
    }

    public void setNameImg(String nameImg) {
        this.nameImg = nameImg;
    }

    public Blog() {
    }
  
    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

    public Blog(String title, String content, String nameImg, Category category) {
        this.title = title;
        this.content = content;
        this.nameImg = nameImg;
        this.category = category;
    }

    public Boolean getBoxCheck() {
        return boxCheck;
    }

    public void setBoxCheck(Boolean boxCheck) {
        this.boxCheck = boxCheck;
    }
    @Override
    public String toString() {
        return String.format("Blog[id=%d, title='%s', nameImg='%s']", id, title, nameImg);
    }
}
