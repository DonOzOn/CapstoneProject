package com.realestatebrokerage.domain;


import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.io.Serializable;

@Entity
@Table(name = "notification")
public class Notification extends AbstractAuditingEntity implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(referencedColumnName = "id", name = "user_id")
    private User user;

    @Column(name = "type")
    private Integer type;

    @Column(name = "content")
    private String content;

    @Column(name = "status")
    private boolean status;

    public Notification() {
    }

    public Notification(User user, Integer type, String content, boolean status) {
        this.user = user;
        this.type = type;
        this.content = content;
        this.status = status;
    }

    public boolean isStatus() {
        return status;
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
}
