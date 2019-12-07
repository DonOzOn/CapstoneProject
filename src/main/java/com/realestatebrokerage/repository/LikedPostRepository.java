package com.realestatebrokerage.repository;

import com.realestatebrokerage.domain.LikedPost;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Optional;

public interface LikedPostRepository extends JpaRepository<LikedPost, Long> {
    public List<LikedPost> findAll();

    public Optional<LikedPost> findByProductPostIdAndUserId(Long postId, Long userId);

    public int countAllByUserIdAndProductPostId(Long userid, Long postId);

    public int countAllByProductPostIdAndStatusIsTrue(Long postId);

    @Query("SELECT COUNT(l) FROM LikedPost l WHERE l.user.id = :userId")
    public Long count(@Param("userId") Long userId);
}
