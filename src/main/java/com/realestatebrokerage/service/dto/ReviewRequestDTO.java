package com.realestatebrokerage.service.dto;
import com.realestatebrokerage.domain.*;

import java.time.Instant;

public class ReviewRequestDTO {
  private Long id;
    private String  title;
    private String  decription;
    private String  content;
    private Integer totalLike;
    private Integer totalReport;
    private Integer totalShare;
    private boolean type;
    private String ward;
    private String province;
    private String district;
    private boolean status = false;
    private String imageUrl;
    private Long user;
    private String createdBy;
    private Instant createdDate;
    private String lastModifiedBy;
    private Instant lastModifiedDate;

    public ReviewRequestDTO() {
    }

    public ReviewRequestDTO(Review review) {
        this.id = review.getId();
        this.title = review.getTitle();
        this.decription = review.getDecription();
        this.content = review.getContent();
        this.province =  review.getProvince().getCode();
        this.district =  review.getDistrict().getCode();
        this.ward =  review.getWard().getCode();
        this.status = review.isStatus();
        this.imageUrl = review.getImageUrl();
        this.type = review.isType();
        this.user = review.getUser().getId();
        this.createdBy = review.getCreatedBy();
        this.createdDate = review.getCreatedDate();
        this.lastModifiedBy = review.getLastModifiedBy();
        this.lastModifiedDate = review.getLastModifiedDate();
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDecription() {
        return decription;
    }

    public void setDecription(String decription) {
        this.decription = decription;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
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

    public boolean isType() {
        return type;
    }

    public void setType(boolean type) {
        this.type = type;
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

    public boolean isStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }

    public Long getUser() {
        return user;
    }

    public void setUser(Long user) {
        this.user = user;
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

    @Override
    public String toString() {
        return "ReviewRequestDTO{" +
            "id=" + id +
            ", title='" + title + '\'' +
            ", decription='" + decription + '\'' +
            ", content='" + content + '\'' +
            ", totalLike=" + totalLike +
            ", totalReport=" + totalReport +
            ", totalShare=" + totalShare +
            ", type=" + type +
            ", ward='" + ward + '\'' +
            ", province='" + province + '\'' +
            ", district='" + district + '\'' +
            ", status=" + status +
            ", imageUrl='" + imageUrl + '\'' +
            ", user=" + user +
            ", createdBy='" + createdBy + '\'' +
            ", createdDate=" + createdDate +
            ", lastModifiedBy='" + lastModifiedBy + '\'' +
            ", lastModifiedDate=" + lastModifiedDate +
            '}';
    }
}
