package com.realestatebrokerage.domain;

import com.realestatebrokerage.config.Constants;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.io.Serializable;

/**
 * A comment_product_post.
 */
@Entity
@Table(name = "comment_product_post")
public class CommentProductPost extends AbstractAuditingEntity implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(referencedColumnName = "id", name = "user_id")
    private User user;

    @ManyToOne
    @JoinColumn(referencedColumnName = "id", name = "product_post_id")
    private ProductPost productPost;

    @Size(min=1, max = 50)
    @Column(name = "content", length = 1000)
    private String content;

    @Size( max = 50)
    @Column(name = "total_like")
    private int totalLike;

    @Size(max = 50)
    @Column(name = "total_dislike")
    private int totalDislike;


    public CommentProductPost(CommentProductPost commentProductPost) {
        this.id= commentProductPost.getId();
        if(commentProductPost.getUser() !=null){
            this.user=commentProductPost.getUser();
        }
        if(commentProductPost.getProductPost()!=null){
            this.productPost=commentProductPost.getProductPost();
        }
        this.content= commentProductPost.getContent();
        this.totalLike= commentProductPost.getTotalLike();
        this.totalDislike= commentProductPost.getTotalDislike();
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public ProductPost getProductPost() {
        return productPost;
    }

    public void setProductPost(ProductPost productPost) {
        this.productPost = productPost;
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
