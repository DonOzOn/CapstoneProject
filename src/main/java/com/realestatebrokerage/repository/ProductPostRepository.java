package com.realestatebrokerage.repository;

import com.realestatebrokerage.domain.ProductPost;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ProductPostRepository extends JpaRepository<ProductPost, Long> {
    public List<ProductPost> findAllByStatusTrue();
}
