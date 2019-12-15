package com.realestatebrokerage.domain;


import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.io.Serializable;

@Entity
@Table(name = "guest_care_product")
public class GuestCareProduct extends AbstractAuditingEntity implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Size(max = 12)
    @Column(name = "phone", length = 12)
    private String phone;

    @Size(max = 256)
    @Column(name = "email", length = 256)
    private String email;

    @Size(max = 50)
    @Column(name = "name", length = 50)
    private String name;

    @Size(max = 200)
    @Column(name = "mess", length = 200)
    private String mess;

    @ManyToOne
    @JoinColumn(referencedColumnName = "id", name = "product_post_id")
    private ProductPost productPost;

    @ManyToOne
    @JoinColumn(referencedColumnName = "id", name = "user_id")
    private User user;

    @NotNull
    @Column(name = "status")
    private boolean status;


    public GuestCareProduct() {
    }

    public GuestCareProduct(@Size(max = 12) String phone, @Email @Size(max = 256) String email, @Size(max = 50) String name, @Size(max = 200) String mess, ProductPost productPost, User user, @NotNull boolean status) {
        this.phone = phone;
        this.email = email;
        this.name = name;
        this.mess = mess;
        this.productPost = productPost;
        this.user = user;
        this.status = status;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getMess() {
        return mess;
    }

    public void setMess(String mess) {
        this.mess = mess;
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

    public boolean isStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }
}
