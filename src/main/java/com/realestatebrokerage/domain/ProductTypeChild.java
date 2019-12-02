package com.realestatebrokerage.domain;

import com.realestatebrokerage.config.Constants;
import com.fasterxml.jackson.annotation.JsonIgnore;
import org.apache.commons.lang3.StringUtils;
import org.hibernate.annotations.BatchSize;
import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;
import org.hibernate.search.annotations.ContainedIn;
import org.hibernate.search.annotations.Field;

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
 * A product_type_child.
 */
@Entity
@Embeddable
@Table(name = "product_type_child")

public class ProductTypeChild {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(referencedColumnName = "id", name = "product_type_id")
    private ProductType productType;

    @Field
    @Size(max = 50)
    @Column(name = "product_type_child_name", length = 50)
    private String productTypeChildName;

    public ProductTypeChild() {
    }

    public ProductTypeChild(ProductType productType, @Size(max = 50) String productTypeChildName) {
        this.productType = productType;
        this.productTypeChildName = productTypeChildName;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public ProductType getProductType() {
        return productType;
    }

    public void setProductType(ProductType productType) {
        this.productType = productType;
    }

    public String getProductTypeChildName() {
        return productTypeChildName;
    }

    public void setProductTypeChildName(String productTypeChildName) {
        this.productTypeChildName = productTypeChildName;
    }
}
