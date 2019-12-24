package com.realestatebrokerage.service.dto;


import com.realestatebrokerage.domain.*;

import java.time.Instant;

public class ReviewResponeDTO {
  private Long id;
    private String  title;
    private String  decription;
    private String  content;
    private Integer totalLike;
    private Integer totalReport;
    private Integer totalShare;
    private boolean type;
    private Ward ward;
    private Province province;
    private District district;
    private boolean status = false;
    private String imageUrl;
    private User user;
    private String createdBy;
    private Instant createdDate;
    private String lastModifiedBy;
    private Instant lastModifiedDate;

    public ReviewResponeDTO() {
    }

    public ReviewResponeDTO(Review review) {
        this.id = review.getId();
        this.title = review.getTitle();
        this.decription = review.getDecription();
        this.content = review.getContent();
        this.province =  review.getProvince();
        this.district =  review.getDistrict();
        this.ward =  review.getWard();
        this.status = review.isStatus();
        this.totalLike = review.getTotalLike();
        this.imageUrl = review.getImageUrl();
        this.type = review.isType();
        this.user = review.getUser();
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

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
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
        return "ReviewResponeDTO{" +
            "id=" + id +
            ", title='" + title + '\'' +
            ", decription='" + decription + '\'' +
            ", content='" + content + '\'' +
            ", totalLike=" + totalLike +
            ", totalReport=" + totalReport +
            ", totalShare=" + totalShare +
            ", type=" + type +
            ", ward=" + ward +
            ", province=" + province +
            ", district=" + district +
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
