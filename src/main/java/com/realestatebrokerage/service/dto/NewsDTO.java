package com.realestatebrokerage.service.dto;
import com.realestatebrokerage.domain.News;

import java.time.Instant;

public class NewsDTO {
  private Long id;
    private String  title;
    private String  decription;
    private String  content;
    private boolean status = false;
    private String createdBy;
    private Instant createdDate;
    private String lastModifiedBy;
    private Instant lastModifiedDate;
    private String imageUrl;

    public NewsDTO() {
    }

    public NewsDTO(News news) {
        this.id = news.getId();
        this.title = news.getTitle();
        this.decription = news.getDecription();
        this.content = news.getContent();
        this.status = news.getStatus();
        this.createdBy = news.getCreatedBy();
        this.createdDate = news.getCreatedDate();
        this.lastModifiedBy = news.getLastModifiedBy();
        this.lastModifiedDate = news.getLastModifiedDate();
        this.imageUrl = news.getImageUrl();
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
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

    public void setId(Long id) {
        this.id = id;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setDecription(String decription) {
        this.decription = decription;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }

    public Long getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public String getDecription() {
        return decription;
    }

    public String getContent() {
        return content;
    }

    public boolean isStatus() {
        return status;
    }

    @Override
    public String toString() {
        return "NewRequestDTO{" +
            "id=" + id +
            ", title='" + title + '\'' +
            ", decription='" + decription + '\'' +
            ", content='" + content + '\'' +
            ", status=" + status +
            '}';
    }
}
