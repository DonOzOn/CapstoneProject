package com.realestatebrokerage.service.dto;

import com.realestatebrokerage.domain.Image;

import java.time.Instant;

public class PostRequestDTO {
    ProductRequestDTO productRequestDTO;
    ProductPostRequestDTO productPostRequestDTO;
    ImageDTO imageDTO;
    UsingImageRequestDTO usingImageRequestDTO;

    public PostRequestDTO() {
    }

    public ProductRequestDTO getProductRequestDTO() {
        return productRequestDTO;
    }

    public void setProductRequestDTO(ProductRequestDTO productRequestDTO) {
        this.productRequestDTO = productRequestDTO;
    }

    public ProductPostRequestDTO getProductPostRequestDTO() {
        return productPostRequestDTO;
    }

    public void setProductPostRequestDTO(ProductPostRequestDTO productPostRequestDTO) {
        this.productPostRequestDTO = productPostRequestDTO;
    }

    public ImageDTO getImageDTO() {
        return imageDTO;
    }

    public void setImageDTO(ImageDTO imageDTO) {
        this.imageDTO = imageDTO;
    }

    public UsingImageRequestDTO getUsingImageRequestDTO() {
        return usingImageRequestDTO;
    }

    public void setUsingImageRequestDTO(UsingImageRequestDTO usingImageRequestDTO) {
        this.usingImageRequestDTO = usingImageRequestDTO;
    }
}
