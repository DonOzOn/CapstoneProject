package com.realestatebrokerage.repository;

import com.realestatebrokerage.domain.LikedPost;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface LikedPostRepository extends JpaRepository<LikedPost, Long> {
    public List<LikedPost> findAll();

}
