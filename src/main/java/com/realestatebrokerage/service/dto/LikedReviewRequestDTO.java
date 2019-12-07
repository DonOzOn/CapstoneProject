package com.realestatebrokerage.service.dto;
import com.realestatebrokerage.domain.LikedReview;
import com.realestatebrokerage.domain.Review;
import com.realestatebrokerage.domain.User;

import java.time.Instant;

public class LikedReviewRequestDTO {
    private Long id;
    private Long user;
    private Long review;
    private boolean status = false;
    private String createdBy;
    private Instant createdDate;
    private String lastModifiedBy;
    private Instant lastModifiedDate;

    public LikedReviewRequestDTO() {
    }

    public LikedReviewRequestDTO(LikedReview likedReview) {
        this.user = likedReview.getUser().getId();
        this.review = likedReview.getReview().getId();
        this.status = likedReview.isStatus();
        this.createdBy = likedReview.getCreatedBy();
        this.createdDate = likedReview.getCreatedDate();
        this.lastModifiedBy = likedReview.getLastModifiedBy();
        this.lastModifiedDate = likedReview.getLastModifiedDate();
    }


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getUser() {
        return user;
    }

    public void setUser(Long user) {
        this.user = user;
    }

    public Long getReview() {
        return review;
    }

    public void setReview(Long review) {
        this.review = review;
    }

    public boolean isStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }

    public String getCreatedBy() {
        return createdBy;
    }

    public void setCreatedBy(String createdBy) {
        this.createdBy = createdBy;
    }

    public Instant getCreatedDate() {
        return createdDate;
    }

    public void setCreatedDate(Instant createdDate) {
        this.createdDate = createdDate;
    }

    public String getLastModifiedBy() {
        return lastModifiedBy;
    }

    public void setLastModifiedBy(String lastModifiedBy) {
        this.lastModifiedBy = lastModifiedBy;
    }

    public Instant getLastModifiedDate() {
        return lastModifiedDate;
    }

    public void setLastModifiedDate(Instant lastModifiedDate) {
        this.lastModifiedDate = lastModifiedDate;
    }
}
