package com.realestatebrokerage.repository;

import com.realestatebrokerage.domain.Image;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ImageRepository extends JpaRepository<Image, Long> {
    public List<Image> findAll();
}
