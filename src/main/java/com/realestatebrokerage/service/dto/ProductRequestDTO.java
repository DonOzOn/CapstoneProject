package com.realestatebrokerage.service.dto;
import com.realestatebrokerage.domain.Product;

import java.time.LocalDateTime;
import java.util.Date;

public class ProductRequestDTO {
    private Long id;
    private String price;
    private String area;
    private Long direction;
    private Long legalStatus;
    private int numberFloor;
    private int numberBathroom;
    private int numberBedroom;
    private Long productTypeChild;
    private Long productType;
    private boolean status;

    public ProductRequestDTO() {
    }

    public ProductRequestDTO(Product product) {
        this.id = product.getId();
        this.price = product.getPrice();
        this.area = product.getArea();
        if(product.getDirection()!= null){
            this.direction = product.getDirection().getId();
        }
        if(product.getLegalStatus()!= null){
            this.legalStatus = product.getLegalStatus().getId();
        }
        this.numberFloor = product.getNumberFloor();
        this.numberBathroom = product.getNumberBathroom();
        this.numberBedroom = product.getNumberBedroom();
        if(product.getProductTypeChild()!= null){
            this.productTypeChild = product.getProductTypeChild().getId();
        }
        if(product.getProductType()!= null){
            this.productType = product.getProductType().getId();
        }
        this.status = product.isStatus();
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

    public Long getDirection() {
        return direction;
    }

    public void setDirection(Long direction) {
        this.direction = direction;
    }

    public Long getLegalStatus() {
        return legalStatus;
    }

    public void setLegalStatus(Long legalStatus) {
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

    public Long getProductTypeChild() {
        return productTypeChild;
    }

    public void setProductTypeChild(Long productTypeChild) {
        this.productTypeChild = productTypeChild;
    }

    public Long getProductType() {
        return productType;
    }

    public void setProductType(Long productType) {
        this.productType = productType;
    }

    public boolean isStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return "ProductRequestDTO{" +
            "id=" + id +
            ", price='" + price + '\'' +
            ", area='" + area + '\'' +
            ", direction=" + direction +
            ", legalStatus=" + legalStatus +
            ", numberFloor=" + numberFloor +
            ", numberBathroom=" + numberBathroom +
            ", numberBedroom=" + numberBedroom +
            ", productTypeChild=" + productTypeChild +
            ", productType=" + productType +
            ", status=" + status +
            '}';
    }
}
