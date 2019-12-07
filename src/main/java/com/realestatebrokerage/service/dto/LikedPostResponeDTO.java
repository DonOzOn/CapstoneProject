package com.realestatebrokerage.service.dto;
import com.realestatebrokerage.domain.LikedPost;
import com.realestatebrokerage.domain.ProductPost;
import com.realestatebrokerage.domain.User;

import java.time.Instant;

public class LikedPostResponeDTO {
  private Long id;
    private User user;
    private ProductPost productPost;
    private boolean status = false;
    private String createdBy;
    private Instant createdDate;
    private String lastModifiedBy;
    private Instant lastModifiedDate;

    public LikedPostResponeDTO() {
    }

    public LikedPostResponeDTO(LikedPost likedPost) {
        this.user = likedPost.getUser();
        this.productPost = likedPost.getProductPost();
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

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public ProductPost getProductPost() {
        return productPost;
    }

    public void setProductPost(ProductPost productPost) {
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
