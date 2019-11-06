package com.realestatebrokerage.domain;


import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "comment_review")
public class CommentReview extends AbstractAuditingEntity implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(referencedColumnName = "id", name = "review_id")
    private Review review;

    @ManyToOne
    @JoinColumn(referencedColumnName = "id", name = "user_id")
    private User user;

    @Column(name = "total_like")
    private Integer totalLike;

    @Column(name = "total_dislike")
    private Integer totalDislike;


    public CommentReview() {
    }

    public CommentReview(Review review, User user, Integer totalLike, Integer totalDislike) {
        this.review = review;
        this.user = user;
        this.totalLike = totalLike;
        this.totalDislike = totalDislike;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Review getReview() {
        return review;
    }

    public void setReview(Review review) {
        this.review = review;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }


    public Integer getTotalLike() {
        return totalLike;
    }

    public void setTotalLike(Integer totalLike) {
        this.totalLike = totalLike;
    }

    public Integer getTotalDislike() {
        return totalDislike;
    }

    public void setTotalDislike(Integer totalDislike) {
        this.totalDislike = totalDislike;
    }
}
