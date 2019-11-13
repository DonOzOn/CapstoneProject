package com.realestatebrokerage.service.dto;
import com.realestatebrokerage.domain.New;
import com.realestatebrokerage.domain.ProductPost;

public class NewDTO {
  private Long id;
    private String  title;
    private String  decription;
    private String  content;
    private boolean status = false;

    public NewDTO() {
    }

    public NewDTO(New news) {
        this.id = news.getId();
        this.title = news.getTitle();
        this.decription = news.getDecription();
        this.content = news.getContent();
        this.status = news.getStatus();

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
