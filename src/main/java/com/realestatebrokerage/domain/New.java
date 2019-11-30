package com.realestatebrokerage.domain;


import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.io.Serializable;

@Entity
@Table(name = "new")
public class New extends AbstractAuditingEntity implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(length = 100, name = "title")
    private String  title;

    @Column(length = 200, name = "decription")
    private String  decription;

    @Column(length = 500, name = "content")
    private String  content;


    @NotNull
    @Column(nullable = false)
    private boolean status = false;

    public New() {
    }

    public New(New news){
        this.id = news.getId();
        this.title = news.getTitle();
        this.decription = news.getDecription();
        this.content = news.getContent();
        this.status = news.getStatus();

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
