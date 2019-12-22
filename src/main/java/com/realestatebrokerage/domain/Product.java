package com.realestatebrokerage.domain;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.realestatebrokerage.config.Constants;
import com.fasterxml.jackson.annotation.JsonIgnore;
import org.apache.commons.lang3.StringUtils;
import org.hibernate.annotations.BatchSize;
import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;
import org.hibernate.search.annotations.ContainedIn;
import org.hibernate.search.annotations.Field;
import org.hibernate.search.annotations.FieldBridge;
import org.hibernate.search.annotations.IndexedEmbedded;
import org.hibernate.search.bridge.builtin.LongBridge;

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

    @Column(name = "price")
    private Long price;
    
    @Field
    @FieldBridge(impl = LongBridge.class)
    @Column(name = "area")
    private Long area;


    @IndexedEmbedded(depth = 1, prefix = "direction_")
    @OneToOne
    @JoinColumn(referencedColumnName = "id", name = "direction_id")
    private Direction direction;

    @OneToOne
    @JoinColumn(referencedColumnName = "id", name = "legal_status_id")
    private LegalStatus legalStatus;


    @Column(name = "number_floor")
    private Integer numberFloor;

    @Column(name = "number_bathroom")
    private Integer numberBathroom;

    @Column(name = "number_bedroom")
    private Integer numberBedroom;

    @IndexedEmbedded(depth = 1, prefix = "typeChild_")
    @ContainedIn
    @ManyToOne
    @JoinColumn(referencedColumnName = "id", name = "product_type_child_id")
    private ProductTypeChild productTypeChild;

    @IndexedEmbedded(depth = 1, prefix = "type_")
    @ContainedIn
    @ManyToOne
    @JoinColumn(referencedColumnName = "id", name = "product_type_id")
    private ProductType productType;

    @JsonManagedReference
    @ManyToMany( fetch = FetchType.EAGER)
    @JoinTable(name = "using_utilities", inverseJoinColumns = {
        @JoinColumn(name = "utilities_id", referencedColumnName = "id")}, joinColumns = {
        @JoinColumn(name = "product_id", referencedColumnName = "id")})
    private List<Utilities> utilities;

    @NotNull
    @Column(name = "status", nullable = false)
    private boolean status = false;


    public Product() {
    }

    public Product(Long price, Long area, Direction direction, LegalStatus legalStatus, Integer numberFloor, Integer numberBathroom, Integer numberBedroom, ProductTypeChild productTypeChild, ProductType productType, List<Utilities> utilities, @NotNull boolean status) {
        this.price = price;
        this.area = area;
        this.direction = direction;
        this.legalStatus = legalStatus;
        this.numberFloor = numberFloor;
        this.numberBathroom = numberBathroom;
        this.numberBedroom = numberBedroom;
        this.productTypeChild = productTypeChild;
        this.productType = productType;
        this.utilities = utilities;
        this.status = status;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getPrice() {
        return price;
    }

    public void setPrice(Long price) {
        this.price = price;
    }

    public Long getArea() {
        return area;
    }

    public void setArea(Long area) {
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
