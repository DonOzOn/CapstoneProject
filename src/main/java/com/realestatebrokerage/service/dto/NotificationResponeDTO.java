package com.realestatebrokerage.service.dto;
import com.realestatebrokerage.domain.Notification;
import com.realestatebrokerage.domain.User;

import java.time.Instant;

public class NotificationResponeDTO {
  private Long id;
    private User userSend;
    private User userReceive;
    private Integer  type;
    private String  content;
    private String title;
    private boolean status = false;
    private String createdBy;
    private Instant createdDate;
    private String lastModifiedBy;
    private Instant lastModifiedDate;


    public NotificationResponeDTO() {
    }

    public NotificationResponeDTO(Notification notification) {
        this.id = notification.getId();
        this.userSend = notification.getUserSend();
        this.userReceive = notification.getUserReceive();
        this.type = notification.getType();
        this.content = notification.getContent();
        this.status = notification.isStatus();
        this.title = notification.getTitle();
        this.createdBy = notification.getCreatedBy();
        this.createdDate = notification.getCreatedDate();
        this.lastModifiedBy = notification.getLastModifiedBy();
        this.lastModifiedDate = notification.getLastModifiedDate();
    }


    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public User getUserSend() {
        return userSend;
    }

    public void setUserSend(User userSend) {
        this.userSend = userSend;
    }

    public User getUserReceive() {
        return userReceive;
    }

    public void setUserReceive(User userReceive) {
        this.userReceive = userReceive;
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
