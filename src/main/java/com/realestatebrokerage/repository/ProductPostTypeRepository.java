package com.realestatebrokerage.repository;

import com.realestatebrokerage.domain.ProductPostType;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface ProductPostTypeRepository extends JpaRepository<ProductPostType, String> {
    public List<ProductPostType> findAll();
    public Optional<ProductPostType> findById(Long id);
}
