package com.realestatebrokerage.repository;

import com.realestatebrokerage.domain.LikedReview;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface LikedReviewRepository extends JpaRepository<LikedReview, Long> {
    public List<LikedReview> findAll();

}
