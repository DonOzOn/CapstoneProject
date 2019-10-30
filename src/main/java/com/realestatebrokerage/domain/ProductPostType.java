package com.realestatebrokerage.domain;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.io.Serializable;

/**
 * A product_post_type.
 */
@Entity
@Table(name = "product_post_type")
public class ProductPostType{

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Size(max = 50)
    @Column(name = "product_post_type_name", length = 50)
    private String productPostTypeName;

    public ProductPostType() {
    }

    public ProductPostType(@Size(max = 50) String productPostTypeName) {
        this.productPostTypeName = productPostTypeName;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getProductPostTypeName() {
        return productPostTypeName;
    }

    public void setProductPostTypeName(String productPostTypeName) {
        this.productPostTypeName = productPostTypeName;
    }
}
