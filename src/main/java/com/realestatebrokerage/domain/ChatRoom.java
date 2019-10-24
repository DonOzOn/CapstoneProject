package com.realestatebrokerage.domain;


import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.io.Serializable;

@Entity
@Table(name = "chat_room")
public class ChatRoom extends AbstractAuditingEntity implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "code_conversation")
    private String codeConservation;

    @ManyToOne
    @JoinColumn(referencedColumnName = "id", name = "user_id")
    private User user;

    @Column(length = 50, name = "content")
    private String content;

    @NotNull
    @Column(name = "status", nullable = false)
    private boolean status = false;



    public ChatRoom() {
    }

    public ChatRoom(ChatRoom chatRoom){
        this.id = chatRoom.getId();
        this.codeConservation = chatRoom.getCodeConservation();
        if (chatRoom.getUser() != null) {
            this.user = chatRoom.getUser();
        }
        this.content = chatRoom.getContent();
        this.status = chatRoom.getStatus();
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getCodeConservation() {
        return codeConservation;
    }

    public void setCodeConservation(String codeConservation) {
        this.codeConservation = codeConservation;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
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
