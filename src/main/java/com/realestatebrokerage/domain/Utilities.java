package com.realestatebrokerage.domain;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.io.Serializable;
import java.util.List;

/**
 * A utilities.
 */
@Entity
@Table(name = "utilities")
public class Utilities{

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Size(max = 50)
    @Column(name = "utilities_name", length = 50)
    private String utilitiesName;

    @ManyToMany
    @JoinTable(name = "using_utilities", inverseJoinColumns = {
        @JoinColumn(name = "product_id", referencedColumnName = "id")}, joinColumns = {
        @JoinColumn(name = "utilities_id", referencedColumnName = "id")})
    private List<Product> product;


    public Utilities() {
    }



    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }


    public String getUtilitiesName() {
        return utilitiesName;
    }

    public void setUtilitiesName(String utilitiesName) {
        this.utilitiesName = utilitiesName;
    }

    public List<Product> getProduct() {
        return product;
    }

    public void setProduct(List<Product> product) {
        this.product = product;
    }
}
