package com.example.bootemo;

import com.example.bootemo.service.BlogService;
import com.example.bootemo.service.CategoryService;
import com.example.bootemo.service.ImageService;
import com.example.bootemo.service.imp.BlogServiceImp;
import com.example.bootemo.service.imp.ImageServiceImpl;
import com.example.bootemo.service.imp.CategoryServiceImp;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class BootemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(BootemoApplication.class, args);
	}
	@Bean
	public BlogService blogService(){return new BlogServiceImp();
	}
	@Bean
	public ImageService imageService(){return new ImageServiceImpl();
	}
	@Bean
	public CategoryService categoryService(){return new CategoryServiceImp();
	}
}

