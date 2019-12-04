package com.realestatebrokerage.service.dto;
import com.realestatebrokerage.domain.GuestCareProduct;
import com.realestatebrokerage.domain.News;
import com.realestatebrokerage.domain.ProductPost;
import com.realestatebrokerage.domain.User;

import java.time.Instant;

public class GuestCareProductResponeDTO {
    private Long id;
    private String  mess;
    private String  phone;
    private String  email;
    private String  name;
    private User user;
    private ProductPost productPost;
    private boolean status = false;
    private String createdBy;
    private Instant createdDate;
    private String lastModifiedBy;
    private Instant lastModifiedDate;

    public GuestCareProductResponeDTO() {
    }

    public GuestCareProductResponeDTO(GuestCareProduct guestCareProduct) {
        this.id = guestCareProduct.getId();
        this.user = guestCareProduct.getUser();
        this.mess = guestCareProduct.getMess();
        this.phone = guestCareProduct.getPhone();
        this.email = guestCareProduct.getEmail();
        this.status = guestCareProduct.isStatus();
        this.name = guestCareProduct.getName();
        this.createdBy = guestCareProduct.getCreatedBy();
        this.createdDate = guestCareProduct.getCreatedDate();
        this.lastModifiedBy = guestCareProduct.getLastModifiedBy();
        this.lastModifiedDate = guestCareProduct.getLastModifiedDate();
        this.productPost = guestCareProduct.getProductPost();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getMess() {
        return mess;
    }

    public void setMess(String mess) {
        this.mess = mess;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
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

    public ProductPost getProductPost() {
        return productPost;
    }

    public void setProductPost(ProductPost productPost) {
        this.productPost = productPost;
    }
}
