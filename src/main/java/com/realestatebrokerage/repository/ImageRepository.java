package com.realestatebrokerage.repository;

import com.realestatebrokerage.domain.Image;
import com.realestatebrokerage.domain.UsingUtilities;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ImageRepository extends JpaRepository<Image, String> {
    public List<Image> findAll();
}
