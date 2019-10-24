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
    private int totalLike;

    @Column(name = "total_dislike")
    private int totalDislike;


    public CommentReview() {
    }

    public CommentReview(CommentReview commentReview){
        this.id = commentReview.getId();
        if (commentReview.getReview() != null) {
            this.review = commentReview.getReview();
        }
        if (commentReview.getUser() != null) {
            this.user = commentReview.getUser();
        }
        this.totalLike = commentReview.getTotalLike();
        this.totalDislike = commentReview.getTotalDislike();

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

    public int getTotalLike() {
        return totalLike;
    }

    public void setTotalLike(int totalLike) {
        this.totalLike = totalLike;
    }

    public int getTotalDislike() {
        return totalDislike;
    }

    public void setTotalDislike(int totalDislike) {
        this.totalDislike = totalDislike;
    }
}
