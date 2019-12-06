package com.realestatebrokerage.service.dto;
import com.realestatebrokerage.domain.LikedPost;
import com.realestatebrokerage.domain.News;

import java.time.Instant;

public class LikedPostRequestDTO {
  private Long id;
    private Long  user;
    private Long  productPost;
    private boolean status = false;
    private String createdBy;
    private Instant createdDate;
    private String lastModifiedBy;
    private Instant lastModifiedDate;

    public LikedPostRequestDTO() {
    }

    public LikedPostRequestDTO(LikedPost likedPost) {
        this.user = likedPost.getUser().getId();
        this.productPost = likedPost.getProductPost().getId();
        this.status = likedPost.isStatus();
        this.createdBy = likedPost.getCreatedBy();
        this.createdDate = likedPost.getCreatedDate();
        this.lastModifiedBy = likedPost.getLastModifiedBy();
        this.lastModifiedDate = likedPost.getLastModifiedDate();

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

    public Long getProductPost() {
        return productPost;
    }

    public void setProductPost(Long productPost) {
        this.productPost = productPost;
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
