package com.realestatebrokerage.service.dto;
import com.realestatebrokerage.domain.ProductPost;
import java.time.LocalDateTime;
import java.util.Date;

public class ProductPostRequestDTO {
    private Long id;
    private Long user;
    private String projectName;
    private Long productPostType;
    private String productPostTitle;
    private Integer totalLike;
    private Integer totalReport;
    private Integer totalShare;
    private Integer typeDeal;
    private String ward;
    private String province;
    private String district;
    private String address;
    private String shortDescription;
    private String content;
    private Long product;
    private boolean status;

    public ProductPostRequestDTO() {
    }

    public ProductPostRequestDTO(ProductPost productPost) {
        this.id = productPost.getId();
        if(productPost.getUser()!= null){
            this.user = productPost.getUser().getId();
        }
        this.projectName = productPost.getProjectName();
        if(productPost.getProductPostType()!= null){
            this.productPostType = productPost.getProductPostType().getId();
        }
        this.productPostTitle = productPost.getProductPostTitle();
        this.totalLike = productPost.getTotalLike();
        this.totalReport = productPost.getTotalReport();
        this.totalShare = productPost.getTotalShare();
        this.typeDeal = productPost.getTypeDeal();
        if(productPost.getWard()!= null){
            this.ward = productPost.getWard().getCode();
        }
        if(productPost.getProvince()!= null){
            this.province = productPost.getProvince().getCode();
        }
        if(productPost.getDistrict()!= null){
            this.district = productPost.getDistrict().getCode();
        }
        this.address = productPost.getAddress();
        this.shortDescription = productPost.getShortDescription();
        this.content = productPost.getContent();
        if(productPost.getProduct()!= null){
            this.product = productPost.getProduct().getId();
        }
        this.status = productPost.isStatus();
    }

    public Long getProductPostType() {
        return productPostType;
    }

    public void setProductPostType(Long productPostType) {
        this.productPostType = productPostType;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getUser() {
        return user;
    }

    public void setUser(Long user) {
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

    public void setTypeDeal(Integer typeDeal) {
        this.typeDeal = typeDeal;
    }

    public String getWard() {
        return ward;
    }

    public void setWard(String ward) {
        this.ward = ward;
    }

    public String getProvince() {
        return province;
    }

    public void setProvince(String province) {
        this.province = province;
    }

    public String getDistrict() {
        return district;
    }

    public void setDistrict(String district) {
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

    public Long getProduct() {
        return product;
    }

    public void setProduct(Long product) {
        this.product = product;
    }

    public boolean isStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }

    public Integer getTypeDeal() {
        return typeDeal;
    }

    @Override
    public String toString() {
        return "ProductPostRequestDTO{" +
            "id=" + id +
            ", user=" + user +
            ", projectName='" + projectName + '\'' +
            ", productPostTitle='" + productPostTitle + '\'' +
            ", totalLike=" + totalLike +
            ", totalReport=" + totalReport +
            ", totalShare=" + totalShare +
            ", typeDeal=" + typeDeal +
            ", ward='" + ward + '\'' +
            ", province='" + province + '\'' +
            ", district='" + district + '\'' +
            ", address='" + address + '\'' +
            ", shortDescription='" + shortDescription + '\'' +
            ", content='" + content + '\'' +
            ", product=" + product +
            ", status=" + status +
            '}';
    }
}
