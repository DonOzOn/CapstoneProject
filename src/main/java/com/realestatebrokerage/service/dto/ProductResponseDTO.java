package com.realestatebrokerage.service.dto;

import com.realestatebrokerage.domain.*;
import java.time.Instant;
import java.time.LocalDateTime;

public class ProductResponseDTO {
    private Long id;
    private String price;
    private String area;
    private Direction direction;
    private LegalStatus legalStatus;
    private int numberFloor;
    private int numberBathroom;
    private int numberBedroom;
    private ProductTypeChild productTypeChild;
    private ProductType productType;
    private boolean status;
    private String createdBy;
    private Instant createdDate;
    private String lastModifiedBy;
    private Instant lastModifiedDate;

    public ProductResponseDTO() {
    }

    public ProductResponseDTO(Product product) {
        this.id = product.getId();
        this.price = product.getPrice();
        this.area = product.getArea();
        if(product.getDirection()!= null){
            this.direction = product.getDirection();
        }
        if(product.getLegalStatus()!= null){
            this.legalStatus = product.getLegalStatus();
        }
        this.numberFloor = product.getNumberFloor();
        this.numberBathroom = product.getNumberBathroom();
        this.numberBedroom = product.getNumberBedroom();
        if(product.getProductTypeChild()!= null){
            this.productTypeChild = product.getProductTypeChild();
        }
        if(product.getProductType()!= null){
            this.productType = product.getProductType();
        }
        this.status = product.isStatus();
        if (product.getCreatedBy() != null) {
            this.createdBy = product.getCreatedBy();
        }
        if (product.getLastModifiedBy() != null) {
            this.lastModifiedBy = product.getLastModifiedBy();
        }
        if (product.getCreatedDate() != null) {
            this.createdDate = product.getCreatedDate();
        }
        this.lastModifiedDate = product.getLastModifiedDate();

    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public String getArea() {
        return area;
    }

    public void setArea(String area) {
        this.area = area;
    }

    public Direction getDirection() {
        return direction;
    }

    public void setDirection(Direction direction) {
        this.direction = direction;
    }

    public LegalStatus getLegalStatus() {
        return legalStatus;
    }

    public void setLegalStatus(LegalStatus legalStatus) {
        this.legalStatus = legalStatus;
    }

    public int getNumberFloor() {
        return numberFloor;
    }

    public void setNumberFloor(int numberFloor) {
        this.numberFloor = numberFloor;
    }

    public int getNumberBathroom() {
        return numberBathroom;
    }

    public void setNumberBathroom(int numberBathroom) {
        this.numberBathroom = numberBathroom;
    }

    public int getNumberBedroom() {
        return numberBedroom;
    }

    public void setNumberBedroom(int numberBedroom) {
        this.numberBedroom = numberBedroom;
    }

    public ProductTypeChild getProductTypeChild() {
        return productTypeChild;
    }

    public void setProductTypeChild(ProductTypeChild productTypeChild) {
        this.productTypeChild = productTypeChild;
    }

    public ProductType getProductType() {
        return productType;
    }

    public void setProductType(ProductType productType) {
        this.productType = productType;
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
