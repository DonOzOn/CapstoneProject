package com.realestatebrokerage.repository;

import com.realestatebrokerage.domain.UsingImage;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface UsingImageRepository extends JpaRepository<UsingImage, Long> {
    public List<UsingImage> findAll();

    public Optional<UsingImage> findByProductPostId(Long id);
}
