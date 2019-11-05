package com.realestatebrokerage.repository;

import com.realestatebrokerage.domain.Product;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ProductRepository extends JpaRepository<Product, String> {
    public List<Product> findAll();
}
