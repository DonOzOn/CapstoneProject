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

    @Email
    @Size(max = 50)
    @Column(name = "email", length = 50)
    private String email;

    @ManyToOne
    @JoinColumn(referencedColumnName = "id", name = "product_post_id")
    private ProductPost productPost;

    @NotNull
    @Column(nullable = false)
    private boolean status = false;


    public GuestCareProduct() {
    }

    public GuestCareProduct(GuestCareProduct guestCareProduct){
        this.id = guestCareProduct.getId();
        this.phone = guestCareProduct.getPhone();
        this.email = guestCareProduct.getEmail();
        this.status = guestCareProduct.getStatus();
        if (guestCareProduct.getProductPost() != null) {
            this.productPost = guestCareProduct.getProductPost();
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

    public boolean getStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }
}
