package com.realestatebrokerage.service.dto;

import com.realestatebrokerage.domain.*;

import java.time.Instant;
import java.time.LocalDateTime;

public class ProductPostResponseDTO {
    private Long id;
    private User user;
    private String projectName;
    private ProductPostType productPostType;
    private String productPostTitle;
    private Integer totalLike;
    private Integer totalReport;
    private Integer totalShare;
    private Integer typeDeal;
    private Ward ward;
    private Province province;
    private District district;
    private String address;
    private String shortDescription;
    private String content;
    private Product product;
    private boolean status;
    private String createdBy;
    private Instant createdDate;
    private String lastModifiedBy;
    private Instant lastModifiedDate;

    public ProductPostResponseDTO() {
    }

    public ProductPostResponseDTO(ProductPost productPost) {
        this.id = productPost.getId();
        this.user = productPost.getUser();
        this.projectName = productPost.getProjectName();
        if (productPost.getProductPostType() != null) {
            this.productPostType = productPost.getProductPostType();
        }
        this.productPostTitle = productPost.getProductPostTitle();
        this.totalLike = productPost.getTotalLike();
        this.totalReport = productPost.getTotalReport();
        this.totalShare = productPost.getTotalShare();
        if (productPost.getWard() != null) {
            this.ward = productPost.getWard();
        }
        if (productPost.getProvince() != null) {
            this.province = productPost.getProvince();
        }
        if (productPost.getDistrict() != null) {
            this.district = productPost.getDistrict();
        }
        this.address = productPost.getAddress();
        this.content = productPost.getContent();
        if (productPost.getProduct() != null) {
            this.product = productPost.getProduct();
        }
        this.status = productPost.isStatus();
        if (productPost.getCreatedBy() != null) {
            this.createdBy = productPost.getCreatedBy();
        }
        if (productPost.getLastModifiedBy() != null) {
            this.lastModifiedBy = productPost.getLastModifiedBy();
        }
        if (productPost.getCreatedDate() != null) {
            this.createdDate = productPost.getCreatedDate();
        }
        this.lastModifiedDate = productPost.getLastModifiedDate();

    }

    public ProductPostType getProductPostType() {
        return productPostType;
    }

    public void setProductPostType(ProductPostType productPostType) {
        this.productPostType = productPostType;
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

    public String getProjectName() {
        return projectName;
    }

    public void setProjectName(String projectName) {
        this.projectName = projectName;
    }

    public String getProductPostTitle() {
        return productPostTitle;
    }

    public void setProductPostTitle(String productPostTitle) {
        this.productPostTitle = productPostTitle;
    }

    public Integer getTotalLike() {
        return totalLike;
    }

    public void setTotalLike(Integer totalLike) {
        this.totalLike = totalLike;
    }

    public Integer getTotalReport() {
        return totalReport;
    }

    public void setTotalReport(Integer totalReport) {
        this.totalReport = totalReport;
    }

    public Integer getTotalShare() {
        return totalShare;
    }

    public void setTotalShare(Integer totalShare) {
        this.totalShare = totalShare;
    }

    public Integer getTypeDeal() {
        return typeDeal;
    }

    public void setTypeDeal(Integer typeDeal) {
        this.typeDeal = typeDeal;
    }

    public Ward getWard() {
        return ward;
    }

    public void setWard(Ward ward) {
        this.ward = ward;
    }

    public Province getProvince() {
        return province;
    }

    public void setProvince(Province province) {
        this.province = province;
    }

    public District getDistrict() {
        return district;
    }

    public void setDistrict(District district) {
        this.district = district;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getShortDescription() {
        return shortDescription;
    }

    public void setShortDescription(String shortDescription) {
        this.shortDescription = shortDescription;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
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
