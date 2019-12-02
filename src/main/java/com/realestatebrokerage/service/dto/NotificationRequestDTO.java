package com.realestatebrokerage.service.dto;
import com.realestatebrokerage.domain.News;
import com.realestatebrokerage.domain.Notification;
import com.realestatebrokerage.domain.User;

import java.time.Instant;

public class NotificationRequestDTO {
  private Long id;
    private Long user;
    private Integer  type;
    private String  content;
    private boolean status = false;
    private String createdBy;
    private Instant createdDate;
    private String lastModifiedBy;
    private Instant lastModifiedDate;


    public NotificationRequestDTO() {
    }

    public NotificationRequestDTO(Notification notification) {
        this.id = notification.getId();
        this.user = notification.getUser().getId();
        this.type = notification.getType();
        this.content = notification.getContent();
        this.status = notification.isStatus();
        this.createdBy = notification.getCreatedBy();
        this.createdDate = notification.getCreatedDate();
        this.lastModifiedBy = notification.getLastModifiedBy();
        this.lastModifiedDate = notification.getLastModifiedDate();
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

    public Integer getType() {
        return type;
    }

    public void setType(Integer type) {
        this.type = type;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
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
