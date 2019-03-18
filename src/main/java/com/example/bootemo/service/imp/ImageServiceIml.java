package com.example.bootemo.service.imp;

import com.example.bootemo.model.Image;
import com.example.bootemo.repository.ImageRepository;
import com.example.bootemo.service.ImageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.Resource;
import org.springframework.core.io.ResourceLoader;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;

public class ImageServiceIml implements ImageService {
    private String UPLOAD = "upload-dir";

    @Autowired
    private ImageRepository imageRepository;

    @Autowired
    private ResourceLoader resourceLoader;

    @Override
    public List<Image> findAll() {
        return (List<Image>) imageRepository.findAll();
    }

    @Override
    public Resource findOneImage(String name) {
        return resourceLoader.getResource("file:"+UPLOAD+"/"+name);
    }

    @Override
    public void create(MultipartFile file) throws IOException {
        if (!file.isEmpty()){
            Files.copy(file.getInputStream(), Paths.get(UPLOAD, file.getOriginalFilename()));
            imageRepository.save(new Image(file.getOriginalFilename()));
        }
    }

    @Override
    public void delete(String name) throws IOException {
        Image byName = imageRepository.findByName(name);
        imageRepository.delete(byName);
        Files.deleteIfExists(Paths.get(UPLOAD, name));
    }
}
