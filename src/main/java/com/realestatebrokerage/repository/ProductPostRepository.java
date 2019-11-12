package com.realestatebrokerage.repository;

import com.realestatebrokerage.domain.ProductPost;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface ProductPostRepository extends JpaRepository<ProductPost, Long> {
    public List<ProductPost> findAll();

    @Query(value = "SELECT pp FROM ProductPost pp where 1=1")
    Page<ProductPost> filter(Pageable pageable);
}
