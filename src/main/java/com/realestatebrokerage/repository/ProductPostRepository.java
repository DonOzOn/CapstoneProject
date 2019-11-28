package com.realestatebrokerage.repository;

import com.realestatebrokerage.domain.ProductPost;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.time.Instant;
import java.util.Date;
import java.util.List;

@Repository
public interface ProductPostRepository extends JpaRepository<ProductPost, Long> {
    public List<ProductPost> findAll();
//    Page<ProductPost> findAll(Pageable pageable);
//    Page<ProductPost> findByCreatedDate(Instant createdDate, Pageable pageable);
//    Page<ProductPost> findByPrice(String price, Pageable pageable);

    @Query(value = "SELECT pp FROM ProductPost pp where 1=1")
    Page<ProductPost> filter(Pageable pageable);
    public List<ProductPost> findAllByStatusTrue();

    public List<ProductPost> findAllByCreatedDateBetweenAndStatusIsTrue(Instant from, Instant to);
}
