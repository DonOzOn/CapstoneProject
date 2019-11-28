package com.realestatebrokerage.repository;

import com.realestatebrokerage.domain.ProductPost;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;

import java.time.Instant;
import java.util.Date;
import java.util.List;
import java.util.Optional;

public interface ProductPostRepository extends JpaRepository<ProductPost, Long> {
    public List<ProductPost> findAllByStatusTrue();

    public List<ProductPost> findAllByCreatedDateBetweenAndStatusIsTrue(Instant from, Instant to);

    public List<ProductPost> findAllByStatusTrueAndCreatedByBetween(Instant from, Instant to);

    public List<ProductPost> findAllByUserId(Long id);

    public Optional<ProductPost> findAllByProductId(Long id);
}
