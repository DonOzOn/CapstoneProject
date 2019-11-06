package com.realestatebrokerage.service.dto;
import com.realestatebrokerage.domain.UsingImage;

import java.time.LocalDateTime;
import java.util.Date;

public class UsingImageRequestDTO {
    private Long id;
    private Long image;
    private Long usingType;
    private Long productPost;

    public UsingImageRequestDTO() {
    }

    public UsingImageRequestDTO(UsingImage usingImage) {
        this.id = usingImage.getId();
        if(usingImage.getImage()!= null){
            this.image = usingImage.getImage().getId();
        }
        if(usingImage.getUsingType()!= null){
            this.usingType = usingImage.getUsingType().getId();
        }
        if(usingImage.getProductPost()!= null){
            this.productPost = usingImage.getProductPost().getId();
        }
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getImage() {
        return image;
    }

    public void setImage(Long image) {
        this.image = image;
    }

    public Long getUsingType() {
        return usingType;
    }

    public void setUsingType(Long usingType) {
        this.usingType = usingType;
    }

    public Long getProductPost() {
        return productPost;
    }

    public void setProductPost(Long productPost) {
        this.productPost = productPost;
    }



    @Override
    public String toString() {
        return "UsingImageRequestDTO{" +
            "id=" + id +
            ", image=" + image +
            ", usingType=" + usingType +
            ", productPost=" + productPost +
            '}';
    }
}
