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

    @Size(min=1, max = 50)
    @Column(name = "project_name", length = 200)
    private String projectName;

    @ManyToOne
    @JoinColumn(referencedColumnName = "id", name = "product_post_type_id")
    private ProductPostType productPostType;

    @Size(min=1, max = 50)
    @Column(name = "product_post_title", length = 50)
    private String productPostTitle;

    @Column(name = "total_like")
    private Integer totalLike;

    @Column(name = "type_deal")
    private Integer typeDeal;

    @Column(name = "total_report")
    private Integer totalReport;

    @Column(name = "total_share")
    private Integer totalShare;

    @ManyToOne
    @JoinColumn(name="ward_code",referencedColumnName="code")
    private Ward ward;

    @ManyToOne
    @JoinColumn(name="province_code",referencedColumnName="code")
    private Province province;

    @ManyToOne
    @JoinColumn(name="district_code",referencedColumnName="code")
    private District district;

    @Size(max = 50)
    @Column(name = "address")
    private String address;

    @Size(min=1, max = 100)
    @Column(name = "short_description", length = 100)
    private String shortDescription;

    @Lob
    @Column(name = "content")
    private String content;

    @OneToOne
    @JoinColumn(referencedColumnName = "id", name = "product_id")
    private Product product;

    @NotNull
    @Column(name = "status", nullable = false)
    private boolean status = false;

    public ProductPost() {
    }

    public ProductPost(User user, @Size(min = 1, max = 50) String projectName, ProductPostType productPostType, @Size(min = 1, max = 50) String productPostTitle, Integer totalLike, Integer typeDeal, Integer totalReport, Integer totalShare, Ward ward, Province province, District district, @Size(max = 50) String address, @Size(min = 1, max = 100) String shortDescription, @Size(min = 1, max = 255) String content, Product product, @NotNull boolean status) {
        this.user = user;
        this.projectName = projectName;
        this.productPostType = productPostType;
        this.productPostTitle = productPostTitle;
        this.totalLike = totalLike;
        this.typeDeal = typeDeal;
        this.totalReport = totalReport;
        this.totalShare = totalShare;
        this.ward = ward;
        this.province = province;
        this.district = district;
        this.address = address;
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

    public String getProjectName() {
        return projectName;
    }

    public void setProjectName(String projectName) {
        this.projectName = projectName;
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

    public Integer getTotalLike() {
        return totalLike;
    }

    public void setTotalLike(Integer totalLike) {
        this.totalLike = totalLike;
    }

    public Integer getTypeDeal() {
        return typeDeal;
    }

    public void setTypeDeal(Integer typeDeal) {
        this.typeDeal = typeDeal;
    }

    public Integer getTotalReport() {
        return totalReport;
    }

    public void setTotalReport(Integer totalReport) {
        this.totalReport = totalReport;
    }

    public Integer getTotalShare() {
        return totalShare;
    }

    public void setTotalShare(Integer totalShare) {
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

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
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

    public boolean isStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }
}
