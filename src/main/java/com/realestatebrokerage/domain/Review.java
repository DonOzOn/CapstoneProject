package com.realestatebrokerage.domain;


import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.io.Serializable;

@Entity
@Table(name = "review")
public class Review extends AbstractAuditingEntity implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(referencedColumnName = "id", name = "user_id")
    private User user;

    @Column(length = 100, name = "title")
    private String  title;

    @Column(name = "total_like")
    private int totalLike;

    @Column(name = "total_report")
    private int totalReport;

    @Column(name = "total_share")
    private int totalShare;

    @OneToOne
    @JoinColumn(referencedColumnName = "id", name = "address_id")
    private Address address;

    @Column(length = 200, name = "decription")
    private String  decription;

    @Column(length = 500, name = "content")
    private String  content;

    @NotNull
    @Column(nullable = false)
    private boolean status = false;

    public Review() {

    }

    public Review(Review review){
        this.id = review.getId();
        if (review.getUser() != null) {
            this.user = review.getUser();
        }
        this.title = review.getTitle();
        this.totalLike = review.getTotalLike();
        this.totalReport = review.getTotalReport();
        this.totalShare = review.getTotalShare();
        if (review.getAddress() != null) {
            this.address = review.getAddress();
        }
        this.decription = review.getDecription();
        this.content = review.getContent();
        this.status = review.getStatus();
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

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public int getTotalLike() {
        return totalLike;
    }

    public void setTotalLike(int totalLike) {
        this.totalLike = totalLike;
    }

    public int getTotalReport() {
        return totalReport;
    }

    public void setTotalReport(int totalReport) {
        this.totalReport = totalReport;
    }

    public int getTotalShare() {
        return totalShare;
    }

    public void setTotalShare(int totalShare) {
        this.totalShare = totalShare;
    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
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
