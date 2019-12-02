package com.realestatebrokerage.domain;


import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
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
    private Integer totalLike;

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

    @Column(length = 200, name = "decription")
    private String  decription;

    @Lob
    @Column(name = "content")
    private String  content;

    @Column(name = "type")
    private boolean type  ;

    @Size(max = 256)
    @Column(name = "image_url", length = 256)
    private String imageUrl;

    @NotNull
    @Column(nullable = false)
    private boolean status = false;


    public Review() {

    }

    public Review(User user, String title, Integer totalLike, Integer totalReport, Integer totalShare, Ward ward, Province province, District district, String decription, String content, boolean type, @Size(max = 256) String imageUrl, @NotNull boolean status) {
        this.user = user;
        this.title = title;
        this.totalLike = totalLike;
        this.totalReport = totalReport;
        this.totalShare = totalShare;
        this.ward = ward;
        this.province = province;
        this.district = district;
        this.decription = decription;
        this.content = content;
        this.type = type;
        this.imageUrl = imageUrl;
        this.status = status;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }

    public boolean isType() {
        return type;
    }

    public void setType(boolean type) {
        this.type = type;
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

    public Integer getTotalLike() {
        return totalLike;
    }

    public void setTotalLike(Integer totalLike) {
        this.totalLike = totalLike;
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

    public boolean isStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }
}
