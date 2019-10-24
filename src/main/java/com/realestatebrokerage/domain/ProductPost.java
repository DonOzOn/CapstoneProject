package com.realestatebrokerage.domain;

import org.apache.commons.lang3.StringUtils;

import com.realestatebrokerage.config.Constants;
import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.io.Serializable;
import java.time.Instant;
import java.util.HashSet;
import java.util.Locale;
import java.util.Set;

/**
 * A product_post.
 */
@Entity
@Table(name = "product_post")
public class ProductPost extends AbstractAuditingEntity implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(referencedColumnName = "id", name = "user_id")
    private User user;

    @ManyToOne
    @JoinColumn(referencedColumnName = "id", name = "product_post_type_id")
    private ProductPostType productPostType;

    @Size(min=1, max = 50)
    @Column(name = "product_post_title", length = 50)
    private String productPostTitle;

    @Size( max = 50)
    @Column(name = "total_like")
    private int totalLike;

    @Size(max = 50)
    @Column(name = "total_report")
    private int totalReport;

    @Size(max = 50)
    @Column(name = "total_share")
    private int totalShare;

    @OneToOne
    @JoinColumn(referencedColumnName = "id", name = "address_id")
    private Address address;

    @Size(min=1, max = 50)
    @Column(name = "short_description", length = 200)
    private String shortDescription;

    @Size(min=1, max = 50)
    @Column(name = "content", length = 1000)
    private String content;

    @OneToOne
    @JoinColumn(referencedColumnName = "id", name = "product_id")
    private Product product;

    @NotNull
    @Column(name = "status", nullable = false)
    private boolean status = false;

    public ProductPost(ProductPost productPost) {
        this.id= productPost.getId();
        if(productPost.getUsers() !=null){
            this.user=productPost.getUsers();
        }
        if(productPost.getProductPostType()!=null){
            this.productPostType=productPost.getProductPostType();
        }
        this.productPostTitle= productPost.getProductPostTitle();
        this.totalLike= productPost.getTotalLike();
        this.totalReport= productPost.getTotalReport();
        this.totalShare= productPost.getTotalShare();
        if(productPost.getAddress()!=null){
            this.address=productPost.getAddress();
        }
        this.shortDescription= productPost.getShortDescription();
        this.content= productPost.getContent();
        if(productPost.getProduct()!=null){
            this.product=productPost.getProduct();
        }
        this.status= product.getStatus();
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public User getUsers() {
        return user;
    }

    public void setUsers(User user) {
        this.user = user;
    }

    public ProductPostType getProductPostType() {
        return productPostType;
    }

    public void setProductPostType(ProductPostType productPostType) {
        this.productPostType = productPostType;
    }

    public String getProductPostTitle() {
        return productPostTitle;
    }

    public void setProductPostTitle(String productPostTitle) {
        this.productPostTitle = productPostTitle;
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

    public String getShortDescription() {
        return shortDescription;
    }

    public void setShortDescription(String shortDescription) {
        this.shortDescription = shortDescription;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    public boolean getStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }
}
