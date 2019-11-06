package com.realestatebrokerage.repository;

import com.realestatebrokerage.domain.ProductType;
import com.realestatebrokerage.domain.Province;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ProductTypeRepository extends JpaRepository<ProductType, Long> {
    public List<ProductType> findAll();
}
