package com.realestatebrokerage.domain;

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

    @Size(min=1, max = 50)
    @Column(name = "number_floor", length = 50)
    private int numberFloor;

    @Size(min=1, max = 50)
    @Column(name = "number_bathroom", length = 50)
    private int numberBathroom;

    @Size(min=1, max = 50)
    @Column(name = "number_bedroom", length = 50)
    private int numberBedroom;

    @OneToOne
    @JoinColumn(referencedColumnName = "id", name = "product_type_child_id")
    private ProductTypeChild productTypeChild;

    @OneToOne
    @JoinColumn(referencedColumnName = "id", name = "product_type_id")
    private ProductType productType;

    @NotNull
    @Column(name = "status", nullable = false)
    private boolean status = false;

    public Product(Product product) {
        this.id= product.getId();
        this.price= product.getPrice();
        this.area= product.getArea();
        if(product.getDirection() !=null){
            this.direction=product.getDirection();
        }
        if(product.getLegalStatus() !=null){
            this.legalStatus=product.getLegalStatus();
        }
        this.numberFloor= product.getNumberFloor();
        this.numberBathroom= product.getNumberBathroom();
        this.numberBedroom= product.getNumberBedroom();
        if(product.getProductTypeChild() !=null){
            this.productTypeChild=product.getProductTypeChild();
        }
        if(product.getProductType() !=null){
            this.productType=product.getProductType();
        }
        this.status= product.getStatus();
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

    public int getNumberFloor() {
        return numberFloor;
    }

    public void setNumberFloor(int numberFloor) {
        this.numberFloor = numberFloor;
    }

    public int getNumberBathroom() {
        return numberBathroom;
    }

    public void setNumberBathroom(int numberBathroom) {
        this.numberBathroom = numberBathroom;
    }

    public int getNumberBedroom() {
        return numberBedroom;
    }

    public void setNumberBedroom(int numberBedroom) {
        this.numberBedroom = numberBedroom;
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

    public boolean getStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }
}
