package com.example.bootemo.repository;

import com.example.bootemo.model.Image;
import org.springframework.data.repository.PagingAndSortingRepository;

public interface ImageRepository extends PagingAndSortingRepository<Image, Long> {
}
