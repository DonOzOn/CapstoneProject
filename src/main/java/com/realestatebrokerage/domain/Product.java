package com.realestatebrokerage.domain;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.realestatebrokerage.config.Constants;
import com.fasterxml.jackson.annotation.JsonIgnore;
import org.apache.commons.lang3.StringUtils;
import org.hibernate.annotations.BatchSize;
import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;
import java.io.Serializable;
import java.time.Instant;
import java.util.HashSet;
import java.util.List;
import java.util.Locale;
import java.util.Set;

/**
 * A product.
 */
@Entity
@Table(name = "product")
public class Product extends AbstractAuditingEntity implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Size(max = 50)
    @Column(name = "price", length = 50)
    private String price;

    @Size(max = 50)
    @Column(name = "area", length = 50)
    private String area;

    @OneToOne
    @JoinColumn(referencedColumnName = "id", name = "direction_id")
    private Direction direction;

    @OneToOne
    @JoinColumn(referencedColumnName = "id", name = "legal_status_id")
    private LegalStatus legalStatus;


    @Column(name = "number_floor", length = 50)
    private Integer numberFloor;

    @Column(name = "number_bathroom", length = 50)
    private Integer numberBathroom;

    @Column(name = "number_bedroom", length = 50)
    private Integer numberBedroom;

    @ManyToOne
    @JoinColumn(referencedColumnName = "id", name = "product_type_child_id")
    private ProductTypeChild productTypeChild;

    @ManyToOne
    @JoinColumn(referencedColumnName = "id", name = "product_type_id")
    private ProductType productType;

    @JsonManagedReference
    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(name = "using_utilities", inverseJoinColumns = {
        @JoinColumn(name = "utilities_id", referencedColumnName = "id")}, joinColumns = {
        @JoinColumn(name = "product_id", referencedColumnName = "id")})
    private List<Utilities> utilities;

    @NotNull
    @Column(name = "status", nullable = false)
    private boolean status = false;


    public Product() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public String getArea() {
        return area;
    }

    public void setArea(String area) {
        this.area = area;
    }

    public Direction getDirection() {
        return direction;
    }

    public void setDirection(Direction direction) {
        this.direction = direction;
    }

    public LegalStatus getLegalStatus() {
        return legalStatus;
    }

    public void setLegalStatus(LegalStatus legalStatus) {
        this.legalStatus = legalStatus;
    }

    public ProductTypeChild getProductTypeChild() {
        return productTypeChild;
    }

    public void setProductTypeChild(ProductTypeChild productTypeChild) {
        this.productTypeChild = productTypeChild;
    }

    public ProductType getProductType() {
        return productType;
    }

    public void setProductType(ProductType productType) {
        this.productType = productType;
    }

    public boolean isStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }

    public Integer getNumberFloor() {
        return numberFloor;
    }

    public void setNumberFloor(Integer numberFloor) {
        this.numberFloor = numberFloor;
    }

    public Integer getNumberBathroom() {
        return numberBathroom;
    }

    public void setNumberBathroom(Integer numberBathroom) {
        this.numberBathroom = numberBathroom;
    }

    public Integer getNumberBedroom() {
        return numberBedroom;
    }

    public void setNumberBedroom(Integer numberBedroom) {
        this.numberBedroom = numberBedroom;
    }

    public List<Utilities> getUtilities() {
        return utilities;
    }

    public void setUtilities(List<Utilities> utilities) {
        this.utilities = utilities;
    }
}
