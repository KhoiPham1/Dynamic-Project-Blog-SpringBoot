package com.example.bootemo.controller;


import com.example.bootemo.model.Image;
import com.example.bootemo.service.ImageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.InputStreamResource;
import org.springframework.core.io.Resource;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.List;

@RestController
@CrossOrigin("http://localhost:4200")
public class ImageController {

    @Autowired
    private ImageService imageService;

    @RequestMapping(value = "/image/",method = RequestMethod.POST)
    public ResponseEntity<?> createStaff(@RequestParam(name = "file") MultipartFile file, HttpServletRequest servletRequest) throws URISyntaxException {
        try{
            imageService.create(file);
            URI locationUri = new URI(servletRequest.getRequestURI().toString() + "/")
                    .resolve(file.getOriginalFilename() + "/raw");
            return ResponseEntity.created(locationUri)
                    .body("success upload");
        } catch (IOException e){
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body("fail" + "=>" + e.getMessage());
        }
    }
    @GetMapping("/image/{name:.+}/raw")
    public ResponseEntity<?> oneRawImage (@PathVariable String name){
        try {
            Resource file = imageService.findOneImage(name);
            return ResponseEntity.ok().
                    contentLength(file.contentLength()).
                    contentType(MediaType.IMAGE_JPEG).
                    body(new InputStreamResource(file.getInputStream()));
        } catch (IOException e){
            return ResponseEntity.badRequest().body("couldn't find");
        }
    }

    @RequestMapping(method = RequestMethod.DELETE, value = "/image/{filename:.+}")
    public ResponseEntity<?> deleteFile (@PathVariable String filename) {
        try {
            imageService.delete(filename);
            return ResponseEntity.status(HttpStatus.NO_CONTENT).body("success delete");
        } catch (IOException e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("fail delete");
        }
    }
}
