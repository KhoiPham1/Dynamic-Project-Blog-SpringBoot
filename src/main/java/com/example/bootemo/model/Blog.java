package com.example.bootemo.model;

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
    private Boolean mode;

    public Boolean getMode() {
        return mode;
    }

    public void setMode(Boolean mode) {
        this.mode = mode;
    }

    @ManyToOne
    @JoinColumn(name = "categoryId")
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

    public Blog(String title, String content, String nameImg, Category category, Boolean mode) {
        this.title = title;
        this.content = content;
        this.nameImg = nameImg;
        this.category = category;
        this.mode = mode;
    }

    public Boolean getBoxCheck() {
        return boxCheck;
    }

    public void setBoxCheck(Boolean boxCheck) {
        this.boxCheck = boxCheck;
    }
}
