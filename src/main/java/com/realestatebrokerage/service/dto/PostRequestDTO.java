package com.realestatebrokerage.service.dto;

import com.realestatebrokerage.domain.Image;
import org.springframework.web.multipart.MultipartFile;

import java.time.Instant;
import java.util.List;

public class PostRequestDTO {
    ProductRequestDTO productRequestDTO;
    ProductPostRequestDTO productPostRequestDTO;
    ImageDTO imageDTO;
    UsingImageRequestDTO usingImageRequestDTO;
    List<MultipartFile> listImage;
    public PostRequestDTO() {
    }

    public List<MultipartFile> getListImage() {
        return listImage;
    }

    public void setListImage(List<MultipartFile> listImage) {
        this.listImage = listImage;
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
