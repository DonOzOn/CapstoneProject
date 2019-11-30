package com.realestatebrokerage.domain;


import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.io.Serializable;

@Entity
@Table(name = "news")
public class News extends AbstractAuditingEntity implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(length = 100, name = "title")
    private String  title;

    @Column(length = 200, name = "decription")
    private String  decription;

    @Size(max = 256)
    @Column(name = "image_url", length = 256)
    private String imageUrl;

    @Lob
    @Column(name = "content")
    private String  content;


    @NotNull
    @Column(nullable = false)
    private boolean status = false;

    public News() {
    }

    public News(String title, String decription, @Size(max = 256) String imageUrl, String content, @NotNull boolean status) {
        this.title = title;
        this.decription = decription;
        this.imageUrl = imageUrl;
        this.content = content;
        this.status = status;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
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

    public boolean getStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }
}
