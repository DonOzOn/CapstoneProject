package com.realestatebrokerage.repository;

import com.realestatebrokerage.domain.LikedReview;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Optional;

public interface LikedReviewRepository extends JpaRepository<LikedReview, Long> {
    public List<LikedReview> findAll();

    public Optional<LikedReview> findByReviewIdAndUserId(Long reviewId, Long userId);

    public int countAllByUserIdAndReviewId(Long userid, Long reviewId);

    public int countAllByReviewIdAndStatusIsTrue(Long reviewId);

    @Query("SELECT COUNT(l) FROM LikedReview l WHERE l.user.id = :userId")
    public Long count(@Param("userId") Long userId);
}
