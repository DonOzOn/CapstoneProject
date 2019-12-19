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
    @JoinColumn(referencedColumnName = "id", name = "user_send_id")
    private User userSend;

    @Column(name = "type")
    private Integer type;

    @Column(name = "content")
    private String content;

    @Column(name = "status")
    private boolean status;

    @Column(name = "title")
    private String title;

    @ManyToOne
    @JoinColumn(referencedColumnName = "id", name = "user_receive_id")
    private User userReceive;

    public Notification() {
    }

    public Notification(User userSend, Integer type, String content, boolean status, String title, User userReceive) {
        this.userSend = userSend;
        this.type = type;
        this.content = content;
        this.status = status;
        this.title = title;
        this.userReceive = userReceive;
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

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public User getUserReceive() {
        return userReceive;
    }

    public void setUserReceive(User userReceive) {
        this.userReceive = userReceive;
    }

    @Override
    public String toString() {
        return "Notification{" +
            "id=" + id +
            ", userSend=" + userSend +
            ", type=" + type +
            ", content='" + content + '\'' +
            ", status=" + status +
            ", title='" + title + '\'' +
            ", userReceive=" + userReceive +
            '}';
    }
}
