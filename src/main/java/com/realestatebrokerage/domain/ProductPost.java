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

    @ManyToOne
    @JoinColumn(name="ward_code",referencedColumnName="code")
    private Ward ward;

    @ManyToOne
    @JoinColumn(name="province_code",referencedColumnName="code")
    private Province province;

    @ManyToOne
    @JoinColumn(name="district_code",referencedColumnName="code")
    private District district;

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

    public ProductPost() {
    }

    public ProductPost(User user, ProductPostType productPostType, @Size(min = 1, max = 50) String productPostTitle, @Size(max = 50) int totalLike, @Size(max = 50) int totalReport, @Size(max = 50) int totalShare, Ward ward, Province province, District district, @Size(min = 1, max = 50) String shortDescription, @Size(min = 1, max = 50) String content, Product product, @NotNull boolean status) {
        this.user = user;
        this.productPostType = productPostType;
        this.productPostTitle = productPostTitle;
        this.totalLike = totalLike;
        this.totalReport = totalReport;
        this.totalShare = totalShare;
        this.ward = ward;
        this.province = province;
        this.district = district;
        this.shortDescription = shortDescription;
        this.content = content;
        this.product = product;
        this.status = status;
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

    public Ward getWard() {
        return ward;
    }

    public void setWard(Ward ward) {
        this.ward = ward;
    }

    public Province getProvince() {
        return province;
    }

    public void setProvince(Province province) {
        this.province = province;
    }

    public District getDistrict() {
        return district;
    }

    public void setDistrict(District district) {
        this.district = district;
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

    public boolean isStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }
}
