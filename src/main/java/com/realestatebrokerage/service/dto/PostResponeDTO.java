package com.realestatebrokerage.service.dto;

public class PostResponeDTO {
    ProductResponseDTO productResponseDTO;
    ProductPostResponseDTO productPostResponseDTO;
    ImageDTO imageDTO;
    UsingImageResponseDTO usingImageResponseDTO;



    public PostResponeDTO() {
    }

    public PostResponeDTO(ProductResponseDTO productResponseDTO, ProductPostResponseDTO productPostResponseDTO, ImageDTO imageDTO, UsingImageResponseDTO usingImageResponseDTO) {
        this.productResponseDTO = productResponseDTO;
        this.productPostResponseDTO = productPostResponseDTO;
        this.imageDTO = imageDTO;
        this.usingImageResponseDTO = usingImageResponseDTO;

    }

    public ProductResponseDTO getProductResponseDTO() {
        return productResponseDTO;
    }

    public void setProductResponseDTO(ProductResponseDTO productResponseDTO) {
        this.productResponseDTO = productResponseDTO;
    }

    public ProductPostResponseDTO getProductPostResponseDTO() {
        return productPostResponseDTO;
    }

    public void setProductPostResponseDTO(ProductPostResponseDTO productPostResponseDTO) {
        this.productPostResponseDTO = productPostResponseDTO;
    }

    public ImageDTO getImageDTO() {
        return imageDTO;
    }

    public void setImageDTO(ImageDTO imageDTO) {
        this.imageDTO = imageDTO;
    }

    public UsingImageResponseDTO getUsingImageResponseDTO() {
        return usingImageResponseDTO;
    }

    public void setUsingImageResponseDTO(UsingImageResponseDTO usingImageResponseDTO) {
        this.usingImageResponseDTO = usingImageResponseDTO;
    }


}
