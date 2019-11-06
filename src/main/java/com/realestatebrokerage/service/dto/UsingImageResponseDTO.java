package com.realestatebrokerage.service.dto;

import com.realestatebrokerage.domain.Image;
import com.realestatebrokerage.domain.ProductPost;
import com.realestatebrokerage.domain.UsingImage;
import com.realestatebrokerage.domain.UsingType;

import java.time.Instant;
import java.time.LocalDateTime;

public class UsingImageResponseDTO {
    private Long id;
    private Image image;
    private UsingType usingType;
    private ProductPost productPost;
    private String createdBy;
    private Instant createdDate;
    private String lastModifiedBy;
    private Instant lastModifiedDate;

    public UsingImageResponseDTO() {
    }

    public UsingImageResponseDTO(UsingImage usingImage) {
        this.id = usingImage.getId();
        if(usingImage.getImage()!= null){
            this.image = usingImage.getImage();
        }
        if(usingImage.getUsingType()!= null){
            this.usingType = usingImage.getUsingType();
        }
        if(usingImage.getProductPost()!= null){
            this.productPost = usingImage.getProductPost();
        }
        if (usingImage.getCreatedBy() != null) {
            this.createdBy = usingImage.getCreatedBy();
        }
        if (usingImage.getLastModifiedBy() != null) {
            this.lastModifiedBy = usingImage.getLastModifiedBy();
        }
        if (usingImage.getCreatedDate() != null) {
            this.createdDate = usingImage.getCreatedDate();
        }
        this.lastModifiedDate = usingImage.getLastModifiedDate();

    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Image getImage() {
        return image;
    }

    public void setImage(Image image) {
        this.image = image;
    }

    public UsingType getUsingType() {
        return usingType;
    }

    public void setUsingType(UsingType usingType) {
        this.usingType = usingType;
    }

    public ProductPost getProductPost() {
        return productPost;
    }

    public void setProductPost(ProductPost productPost) {
        this.productPost = productPost;
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
