package com.realestatebrokerage.repository;

import com.realestatebrokerage.domain.Review;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import java.time.Instant;
import java.util.List;

public interface ReviewRepository extends JpaRepository<Review, Long> {

    public List<Review> findAllByStatusIsTrue();

    public Page<Review> findAllByStatusIsTrueAndUserId(Long id, Pageable pageable);

    /**
     * find all review
     * */
    public List<Review> findAllByStatusIsTrueAndTypeIsTrue();

    /**
     * find all review
     * */
    public List<Review> findAllByStatusIsTrueAndTypeIsFalse();

    public List<Review> findAllByStatusTrueAndCreatedDateGreaterThanEqualAndCreatedDateLessThanEqual(Instant from, Instant to);

}
