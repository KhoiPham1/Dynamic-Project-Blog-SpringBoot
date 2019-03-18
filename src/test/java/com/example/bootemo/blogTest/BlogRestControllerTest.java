package com.example.bootemo.blogTest;

import com.example.bootemo.model.Blog;
import org.junit.Before;
import org.junit.Test;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MvcResult;

import static org.junit.Assert.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;

public class BlogRestControllerTest extends BlogTest {
    @Override
    @Before
    public void setUp() {
        super.setUp();
    }

    @Test
    public void getBlogListTest() throws Exception {
        String uri = "/blog/";
        MvcResult mvcResult = mvc.perform(get(uri).accept(MediaType.APPLICATION_JSON_VALUE)).andReturn();
        int status = mvcResult.getResponse().getStatus();
        assertEquals(200, status);
        String content = mvcResult.getResponse().getContentAsString();
        Blog[] blogs = super.mapFromJson(content, Blog[].class);
        assertTrue(blogs.length > 0);
    }

    @Test
    public void getBlogByIdTest() throws Exception {
        String uri = "/blog/7";
        MvcResult mvcResult = mvc.perform(get(uri).accept(MediaType.APPLICATION_JSON_VALUE)).andReturn();
        int status = mvcResult.getResponse().getStatus();
        assertEquals(200, status);
        String content = mvcResult.getResponse().getContentAsString();
        Blog blog = super.mapFromJson(content, Blog.class);
        assertEquals("melon",blog.getContent());
    }

    @Test
    public void createBlogTest() throws Exception {
        String uri = "/blog/";
        Blog blog = new Blog();
        blog.setContent("grape");
        blog.setTitle("longdk");
        String inputJson = super.mapToJson(blog);
        MvcResult mvcResult = mvc.perform(post(uri).contentType(MediaType.APPLICATION_JSON_VALUE).content(inputJson)).andReturn();
        int status = mvcResult.getResponse().getStatus();
        assertEquals(201, status);
    }

    @Test
    public void deleteBlogTest() throws Exception {
        String uri = "/blog/13";
        MvcResult mvcResult = mvc.perform(delete(uri)).andReturn();
        int status = mvcResult.getResponse().getStatus();
        assertEquals(204, status);
    }

    @Test
    public void updateBlogTest() throws Exception {
        String uri = "/blog/7";
        Blog blog = new Blog();
        blog.setTitle("longdk");
        blog.setContent("longdk");
        String inputJson = super.mapToJson(blog);
        MvcResult mvcResult = mvc.perform(patch(uri).contentType(MediaType.APPLICATION_JSON_VALUE).content(inputJson)).andReturn();
        int status = mvcResult.getResponse().getStatus();
        assertEquals(200,status);
    }
}
