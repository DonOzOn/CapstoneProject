package com.realestatebrokerage.domain;


import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.io.Serializable;

@Entity
@Table(name = "ward")
public class UserCareProduct extends AbstractAuditingEntity implements Serializable {
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

    @NotNull
    @Column(nullable = false)
    private boolean status = false;


    public UserCareProduct() {
    }

    public UserCareProduct(UserCareProduct careProduct){
        this.id = careProduct.getId();
        if (careProduct.getUser() != null) {
            this.user = careProduct.getUser();
        }
        this.status = careProduct.getStatus();
        if (careProduct.getProductPost() != null) {
            this.productPost = careProduct.getProductPost();
        }
    }

    public ProductPost getProductPost() {
        return productPost;
    }

    public void setProductPost(ProductPost productPost) {
        this.productPost = productPost;
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

    public boolean getStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }
}
