package com.realestatebrokerage.repository;

import com.realestatebrokerage.domain.UsingImage;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface UsingImageRepository extends JpaRepository<UsingImage, String> {
    public List<UsingImage> findAll();
}
